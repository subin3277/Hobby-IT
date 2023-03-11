package com.a505.hobbyit.common.exception.dto;

public class ResponseMessage {
    //User
    public static final String USER_CREATE_SUCCESS  = "회원 등록 성공";
    public static final String USER_CREATE_FAIL     = "회원 등록 실패";
    public static final String USER_UPDATE_SUCCESS  = "회원 정보 갱신 성공";
    public static final String USER_UPDATE_FAIL     = "회원 정보 갱신 실패";
    public static final String USER_DELETE_SUCCESS  = "회원 삭제 성공";
    public static final String USER_DELETE_FAIL     = "회원 삭제 실패";
    public static final String USER_SEARCH_SUCCESS  = "회원 조회 성공";
    public static final String USER_SEARCH_FAIL     = "회원 조회 실패";
    public static final String NOT_FOUND_USER       = "회원을 찾을 수 없습니다.";
    public static final String INVALID_USER         = "존재하지 않는 회원입니다.";
    public static final String DUPLICATED_USER      = "이미 등록된 회원입니다.";
    public static final String DUPLICATED_EMAIL     = "이미 등록된 이메일입니다.";

    public static final String LOGIN_SUCCESS        = "로그인 성공";
    public static final String LOGIN_FAIL           = "아이디 혹은 비밀번호 오류입니다.";

    //Diary
    public static final String INVALID_DIARY        = "존재하지 않는 다이어리 입니다.";

    public static final String DIARY_POST_SUCCESS   = "다이어리 작성 성공";
    public static final String DIARY_POST_FAIL      = "다이어리 작성 실패";
    public static final String DIARY_GET_SUCCESS    = "다이어리 조회 성공";
    public static final String DIARY_GET_FAIL       = "다이어리 조회 실패";
    public static final String DIARY_PATCH_SUCCESS  = "다이어리 수정 성공";
    public static final String DIARY_PATCH_FAIL     = "다이어리 수정 실패";
    public static final String DIARY_DELETE_SUCCESS = "다이어리 삭제 성공";
    public static final String Diary_DELETE_FAIL    = "다이어리 삭제 실패";


    // Diary Image
    public static final String INVALID_DIARY_IMAGE         = "존재하지 않는 다이어리 이미지 입니다.";

    public static final String DIARY_IMAGE_POST_SUCCESS    = "다이어리 이미지 등록 성공";
    public static final String DIARY_IMAGE_POST_FAIL       = "다이어리 이미지 등록 실패";
    public static final String DIARY_IMAGE_GET_SUCCESS     = "다이어리 이미지 조회 성공";
    public static final String DIARY_IMAGE_GET_FAIL        = "다이어리 이미지 조회 실패";
    public static final String DIARY_IMAGE_PATCH_SUCCESS   = "다이어리 이미지 수정 성공";
    public static final String DIARY_IMAGE_PATCH_FAIL      = "다이어리 이미지 수정 실패";
    public static final String DIARY_IMAGE_DELETE_SUCCESS  = "다이어리 이미지 삭제 성공";
    public static final String DIARY_IMAGE_DELETE_FAIL     = "다이어리 이미지 삭제 실패";

    public static final String DIARY_IMAGE_MAPPING_SUCCESS = "다이어리 이미지 연결 완료";
    public static final String DIARY_IMAGE_MAPPING_FAIL    = "다이어리 이미지 연결 실패";

    // etc
    public static final String DB_ERROR                    = "디비 에러";
    public static final String INTERNAL_SERVER_ERROR       = "서버 내부 에러";
    public static final String NOT_CONTENT                 = "입력 정보가 부족합니다.";
    public static final String BAD_REQUEST                 = "잘못된 요청입니다.";
    public static final String UNAUTHORIZED                = "인증 실패.";
    public static final String AUTHORIZED                  = "인증 성공.";
    public static final String FOUND_TERMS                 = "약관 조회 성공.";
    public static final String NOT_FOUND_TERMS             = "약관 조회 실패.";
    public static final String FOUND_NOTICE                 = "공지사항 조회 성공.";
    public static final String NOT_FOUND_NOTICE             = "공지사 조회 실패.";
    public static final String SUCCESS_QUESTION             = "문의하기 성공 실패.";
}
