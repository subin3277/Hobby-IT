package com.a505.hobbyit.hobbyarticlecomment.service;

import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticleRepository;
import com.a505.hobbyit.hobbyarticle.exception.NoSuchHobbyArticleException;
import com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleComment;
import com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleCommentRepository;
import com.a505.hobbyit.hobbyarticlecomment.dto.CommentRequest;
import com.a505.hobbyit.hobbyarticlecomment.dto.CommentResponse;
import com.a505.hobbyit.hobbyarticlecomment.exception.NoSuchCommentException;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HobbyArticleCommentServiceImpl implements HobbyArticleCommentService{

    private final MemberRepository memberRepository;
    private final HobbyArticleCommentRepository hobbyArticleCommentRepository;
    private final HobbyArticleRepository hobbyArticleRepository;

    @Override
    public void save(String memberId, Long articleId, CommentRequest request) {
        Member member = memberRepository.findById(Long.parseLong(memberId))
                .orElseThrow(NoSuchHobbyException::new);
        HobbyArticle hobbyArticle = hobbyArticleRepository
                .findById(articleId)
                .orElseThrow(NoSuchHobbyArticleException::new);
        HobbyArticleComment hobbyArticleComment = request.toEntity(member, hobbyArticle);

        hobbyArticleCommentRepository.save(hobbyArticleComment);
    }

    @Override
    public List<CommentResponse> findAll(Long articleId) {
        HobbyArticle hobbyArticle = hobbyArticleRepository
                .findById(articleId)
                .orElseThrow(NoSuchHobbyArticleException::new);

        List<HobbyArticleComment> comments = hobbyArticleCommentRepository.findAllByHobbyArticleOrderByIdDesc(hobbyArticle);
        List<CommentResponse> response = new ArrayList<>();
        for (HobbyArticleComment comment : comments) {
            response.add(new CommentResponse().of(comment));
        }
        return response;
    }

    @Transactional
    @Override
    public void updateComment( Long commentId, CommentRequest request) {
        HobbyArticleComment comment = hobbyArticleCommentRepository
                .findById(commentId)
                .orElseThrow(NoSuchCommentException::new);
        comment.updateContent(request.getContent());
    }

    @Override
    public void deleteComment(Long commentId) {
        if(!hobbyArticleCommentRepository.existsById(commentId)) throw new NoSuchCommentException("댓글이 존재하지 않습니다.");
        hobbyArticleCommentRepository.deleteById(commentId);
    }
}
