package com.a505.hobbyit.member.service;

import com.a505.hobbyit.common.file.FileUploader;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.response.MemberHobbyResponse;
import com.a505.hobbyit.member.dto.response.MemberPendingResponse;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.dto.response.MypageResponse;
import com.a505.hobbyit.member.enums.MemberIsSns;
import com.a505.hobbyit.member.enums.MemberPrivilege;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.enums.MemberState;
import com.a505.hobbyit.member.exception.*;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.pending.domain.Pending;
import com.a505.hobbyit.security.SecurityUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    @Value("${oauth.REST_API_KEY}")
    private String REST_API_KEY;
    @Value("${oauth.redirect_uri}")
    private String redirect_uri;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final StringRedisTemplate stringRedisTemplate;
    private final JavaMailSender javaMailSender;
    private final HobbyRepository hobbyRepository;
    private final SecurityUtil securityUtil;
    private final FileUploader fileUploader;

    @Override
    public void signUp(MemberSignupRequest request) {
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new DuplicatedMemberException();
        }

        if (memberRepository.existsByNickname(request.getNickname())) {
            throw new DuplicatedMemberException("중복된 닉네임입니다.");
        }

        Member member = Member.builder()
                .email(request.getEmail())
                .name(request.getName())
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .isSns(MemberIsSns.FALSE)
                .state(MemberState.ACTIVE)
                .privilege(Collections.singleton(MemberPrivilege.GENERAL.name()))
                .build();
        memberRepository.save(member);
    }

    @Override
    public boolean isSns(String email) {
        return memberRepository.existsByEmailAndIsSns(email, MemberIsSns.TRUE);
    }

    @Transactional
    @Override
    public void updateSnsMember(String email, String imgUrl) {
        Member member = memberRepository.findByEmail(email).orElseThrow(NoSuchMemberException::new);
        member.updateSnsMember(imgUrl);
    }

    @Transactional
    @Override
    public MemberResponse login(MemberLoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(NoSuchElementException::new);

        // 0. 회원의 상태를 확인한다.
        MemberState state = member.getState();
        if (state.equals(MemberState.BAN)) {
            throw new NoSuchMemberException("이용에 제한이 걸린 회원입니다.");
        } else if (state.equals(MemberState.RESIGNED)) {
            throw new NoSuchMemberException("탈퇴한 회원입니다.");
        } else if (state.equals(MemberState.WAITING)) {
            member.updateState(MemberState.ACTIVE, null);
        }

        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = request.toAuthentication();

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        MemberResponse tokenInfo = jwtTokenProvider.generateToken(authentication, member, true, "");

        // 4. RefreshToken Redis 저장 (expirationTime 설정을 통해 자동 삭제 처리)
        stringRedisTemplate.opsForValue()
                .set("RT:" + member.getId(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);
        return tokenInfo;
    }

    @Override
    public MemberResponse reissue(MemberReissueRequest request) {
        // 1. Refresh Token 검증
        if (!jwtTokenProvider.validateToken(request.getRefreshToken())) {
            throw new InvalidedRefreshTokenException();
        }

        // 2. Refresh Token 에서 Member id 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(request.getRefreshToken());

        Member member = memberRepository.findById(Long.parseLong(authentication.getName())).orElseThrow(NoSuchElementException::new);

        // 3. Redis 에서 Member id 를 기반으로 저장된 Refresh Token 값을 가져옵니다.
        String refreshToken = stringRedisTemplate.opsForValue().get("RT:" + member.getId());

        // 로그아웃되어 Redis 에 RefreshToken 이 존재하지 않는 경우 처리
        if (ObjectUtils.isEmpty(refreshToken)) {
            throw new InvalidedRefreshTokenException("로그아웃 상태입니다.");
        }
        if (!refreshToken.equals(request.getRefreshToken())) {
            throw new InvalidedRefreshTokenException("Refresh Token 정보가 일치하지 않습니다.");
        }

        // 4. 새로운 토큰 생성
        MemberResponse tokenInfo = jwtTokenProvider.generateToken(authentication, member, false, request.getRefreshToken());

        // 5. RefreshToken Redis 업데이트
        stringRedisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    @Override
    public void logout(final String token) {
        String accessToken = token.split(" ")[1];

        // 1. Access Token 검증
        if (!jwtTokenProvider.validateToken(accessToken)) {
            throw new InvalidedAccessTokenException();
        }

        // 2. Access Token 에서 Member email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);

        // 3. Redis 에서 해당 Member email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        if (stringRedisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            // Refresh Token 삭제
            stringRedisTemplate.delete("RT:" + authentication.getName());
        }

        // 4. 해당 Access Token 유효시간 가지고 와서 BlackList 로 저장하기
        Long expiration = jwtTokenProvider.getExpiration(token);
        stringRedisTemplate.opsForValue().set(accessToken, "logout", expiration, TimeUnit.MILLISECONDS);
    }

    @Transactional
    @Override
    public void resetPassword(MemberMailRequest request, String from) throws MessagingException {
        // 1. 입력된 이메일과 본명을 동시에 만족하는 사용자가 존재하는지 확인
        Member member = memberRepository.findByEmailAndName(request.getEmail(), request.getName()).orElseThrow(NoSuchMemberException::new);

        // 2. 랜덤으로 비밀번호를 생성해서 비밀번호 자동 변경
        char[] charSet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String pwd = "";
        for (int i = 0, idx = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            pwd += charSet[idx];
        }

        member.resetPassword(passwordEncoder.encode(pwd));

        // 3. 이메일로 보낼 메일 내용을 작성하는 부분
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // true는 멀티파트 메세지를 사용하겠다는 의미
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(request.getEmail());
        mimeMessageHelper.setSubject("HOBBY'IT 임시비밀번호 안내 이메일 입니다.");
        // true는 html을 사용하겠다는 의미
        mimeMessageHelper.setText("안녕하세요. HOBBY'IT 임시비밀번호 안내 관련 이메일 입니다.<br> " + " 회원님의 임시 비밀번호는 <b>"
                + pwd + "</b> 입니다.<br> " + "로그인 후에 비밀번호를 변경을 해주세요.", true);
//        mimeMessageHelper.addInline("logo", new FileDataSource("C:/Users/KANG/Desktop/logo.png"));
        javaMailSender.send(mimeMessage);
    }

    @Override
    public MypageResponse findMypage(final String token, final String nickname) {
        String id = jwtTokenProvider.getUser(token);
        memberRepository.findById(Long.parseLong(id)).orElseThrow(NoSuchMemberException::new);

        Member member = memberRepository.findByNickname(nickname)
                .orElseThrow(NoSuchMemberException::new);

        MypageResponse mypageResponse;
        if (memberRepository.existsByIdAndNickname(id, nickname)) {
            mypageResponse = MypageResponse.builder()
                    .email(member.getEmail())
                    .name(member.getName())
                    .nickname(member.getNickname())
                    .intro(member.getIntro())
                    .point(member.getPoint())
                    .pointLevel(member.getPoint() / 100)
                    .pointExp(member.getPoint() % 100)
                    .imgUrl(member.getImgUrl())
                    .build();
        } else {
            mypageResponse = MypageResponse.builder()
                    .nickname(member.getNickname())
                    .intro(member.getIntro())
                    .point(member.getPoint())
                    .pointLevel(member.getPoint() / 100)
                    .pointExp(member.getPoint() % 100)
                    .imgUrl(member.getImgUrl())
                    .build();
        }

        return mypageResponse;
    }

    @Transactional
    @Override
    public void update(final String token, MemberMypageRequest request, MultipartFile multipartFile) {
        Member member = memberRepository.findById(Long.parseLong(jwtTokenProvider.getUser(token)))
                .orElseThrow(NoSuchMemberException::new);

        String imgUrl = fileUploader.upload(multipartFile, "member");

        // 닉네임 공백 체크
        if ("".equals(request.getNickname())) {
            throw new NoSuchMemberException("닉네임은 필수 입력 사항입니다.");
        }

        // 닉네임 중복체크
        if (!member.getNickname().equals(request.getNickname()) &&
                memberRepository.existsByNickname(request.getNickname())) {
            throw new DuplicatedMemberException("중복된 닉네임입니다.");
        }

        member.updateMember(request, imgUrl);
        if (!"".equals(request.getPassword())) {
            member.resetPassword(passwordEncoder.encode(request.getPassword()));
        }

        // sns로그인 사용자는 비밀번호 변경을 못한다.
        if (member.getIsSns().equals(MemberIsSns.TRUE)) {
            member.resetPassword(passwordEncoder.encode(member.getEmail()));
        }
    }

    @Transactional
    @Override
    public void delete(final String token) {
        Member member = memberRepository.findById(Long.parseLong(jwtTokenProvider.getUser(token)))
                .orElseThrow(NoSuchMemberException::new);
        member.checkWaiting();
        member.updateState(MemberState.WAITING, LocalDateTime.now());
    }

    @Override
    public List<MemberHobbyResponse> getHobbyList(final String token, String nickname) {
        String id = jwtTokenProvider.getUser(token);
        memberRepository.findById(Long.parseLong(id)).orElseThrow(NoSuchMemberException::new);

        Member member = memberRepository.findByNickname(nickname)
                .orElseThrow(NoSuchMemberException::new);

        List<HobbyMember> hobbyMembers = member.getHobbyMembers();

        List<MemberHobbyResponse> responses = new ArrayList<>();
        for (HobbyMember hobbyMember : hobbyMembers) {
            Hobby hobby = hobbyRepository.findById(hobbyMember.getHobby().getId()).orElseThrow(NoSuchHobbyException::new);
            MemberHobbyResponse response = new MemberHobbyResponse().of(hobby, hobbyMember);
            responses.add(response);
        }

        return responses;
    }

    @Override
    public List<MemberPendingResponse> getPendingList(final String token) {
        String id = jwtTokenProvider.getUser(token);
        Member member = memberRepository.findById(Long.parseLong(id)).orElseThrow(NoSuchMemberException::new);

        List<Pending> pendings = member.getPendings();

        List<MemberPendingResponse> responses = new ArrayList<>();
        for (Pending pending : pendings) {
            Hobby hobby = hobbyRepository.findById(pending.getHobby().getId()).orElseThrow(NoSuchHobbyException::new);
            MemberPendingResponse response = new MemberPendingResponse().of(hobby, pending);
            responses.add(response);
        }

        return responses;
    }

    @Override
    public String redirectKakao() {
        return "https://kauth.kakao.com/oauth/authorize?client_id=" + REST_API_KEY +
                "&redirect_uri=" + redirect_uri + "&response_type=code";
    }

    @Override
    public String getKakaoToken(String code) {
        String reqURL = "https://kauth.kakao.com/oauth/token";
        String oauth_token = "";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=" + REST_API_KEY);
            sb.append("&redirect_uri=" + redirect_uri);
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            oauth_token = element.getAsJsonObject().get("access_token").getAsString();

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oauth_token;
    }

    @Override
    public List<String> getKakaoMember(String token) {
        List<String> account = new ArrayList<>();

        String reqURL = "https://kapi.kakao.com/v2/user/me";

        // token을 이용하여 사용자 정보 조회
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, token전송

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            //Gson 라이브러리로 JSON파싱
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            account.add(element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString());
            account.add(element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString());
            account.add(element.getAsJsonObject().get("properties").getAsJsonObject().get("profile_image").getAsString());

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return account;
    }

}
