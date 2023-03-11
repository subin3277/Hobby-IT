package com.a505.hobbyit.hobbyarticlecomment.service;

import com.a505.hobbyit.hobbyarticlecomment.dto.CommentRequest;
import com.a505.hobbyit.hobbyarticlecomment.dto.CommentResponse;

import java.util.List;

public interface HobbyArticleCommentService {
    public void save(String memberId, Long articleId, CommentRequest request);
    public List<CommentResponse> findAll(Long articleId);
    public void updateComment( Long commentId, CommentRequest request);
    public void deleteComment(Long commentId);
}
