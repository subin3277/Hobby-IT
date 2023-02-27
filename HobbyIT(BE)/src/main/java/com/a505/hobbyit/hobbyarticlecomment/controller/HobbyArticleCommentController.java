package com.a505.hobbyit.hobbyarticlecomment.controller;

import com.a505.hobbyit.hobbyarticlecomment.dto.CommentRequest;
import com.a505.hobbyit.hobbyarticlecomment.dto.CommentResponse;
import com.a505.hobbyit.hobbyarticlecomment.service.HobbyArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/hobby")
@RequiredArgsConstructor
public class HobbyArticleCommentController {
    private final HobbyArticleCommentService hobbyArticleCommentService;
    @PostMapping(value = "/{hobby-id}/article/{article-id}/comment")
    public ResponseEntity<Void> save(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "hobby-id", required = false) final Long hobbyId,
            @PathVariable("article-id") final Long articleId,
            @RequestBody CommentRequest request
            ){
        hobbyArticleCommentService.save(userDetails.getUsername(), articleId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/{hobby-id}/article/{article-id}/comment")
    public ResponseEntity<List<CommentResponse>> findBy(
            @PathVariable(value = "hobby-id", required = false) final Long hobbyId,
            @PathVariable("article-id") final Long articleId
    ){
        List<CommentResponse> response = hobbyArticleCommentService.findAll(articleId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping(value = "/{hobby-id}/article/{article-id}/comment/{comment-id}")
    public ResponseEntity<Void> updateComment(
            @PathVariable(value = "hobby-id", required = false) final Long hobbyId,
            @PathVariable(value = "article-id", required = false) final Long articleId,
            @PathVariable(value = "comment-id") final Long commentId,
            @RequestBody CommentRequest request
    ){
        hobbyArticleCommentService.updateComment(commentId, request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping(value = "/{hobby-id}/article/{article-id}/comment/{comment-id}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable(value = "hobby-id", required = false) final Long hobbyId,
            @PathVariable(value = "article-id", required = false) final Long articleId,
            @PathVariable(value = "comment-id") final Long commentId
    ){
        hobbyArticleCommentService.deleteComment(commentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
