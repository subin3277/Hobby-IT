package com.a505.hobbyit.hobbyarticlelike.controller;


import com.a505.hobbyit.hobbyarticlelike.service.HobbyArticleLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "api/hobby")
@RestController
public class HobbyArticleLikeController {
    private final HobbyArticleLikeService hobbyArticleLikeService;
    @PostMapping(value = "/{hobby-id}/article/{article-id}")
    public ResponseEntity<Void> checkHobbyArticleLike(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "hobby-id") Long hobbyId,
            @PathVariable(value = "article-id") Long articleId
    ){
        hobbyArticleLikeService.like(userDetails.getUsername(), articleId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
