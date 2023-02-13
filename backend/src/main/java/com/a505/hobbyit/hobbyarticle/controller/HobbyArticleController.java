package com.a505.hobbyit.hobbyarticle.controller;

import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleDetailResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;
import com.a505.hobbyit.hobbyarticle.service.HobbyArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/hobby")
public class HobbyArticleController {

    private final HobbyArticleService hobbyArticleService;


    @PostMapping(value = "/{hobby-id}/article", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Slice<HobbyArticleResponse>> saveArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestPart(value = "request") final HobbyArticleRequest request,
            @RequestPart(value = "multipartFile", required = false) final List<MultipartFile> multipartFile
            ){
        hobbyArticleService.save(userDetails.getUsername(), hobbyId, request, multipartFile);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping(value = "/{hobby-id}/article")
    public ResponseEntity<Slice<HobbyArticleResponse>> getArticleList(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestParam(required = false) final Long storedId,
            final Pageable pageable
            ){
        log.info(pageable.getPageSize()+"");
        log.info("storedID is: " + storedId);
        Slice<HobbyArticleResponse> response = hobbyArticleService.findAll(userDetails.getUsername(), storedId, hobbyId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/{hobby-id}/article/search")
    public ResponseEntity<Slice<HobbyArticleResponse>> searchArticleList(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestParam(required = false) final Long storedId,
            @RequestParam(required = false) final String keyword,
            final Pageable pageable
    ){
        Slice<HobbyArticleResponse> response = hobbyArticleService.findByKeyword(userDetails.getUsername(), storedId, keyword, hobbyId, pageable);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(value = "/{hobby-id}/notice")
    public ResponseEntity<Page<HobbyArticleResponse>> getNoticeList(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
             final Pageable pageable
    ){
        Page<HobbyArticleResponse> response = hobbyArticleService.findAllNotice(userDetails.getUsername(), hobbyId, pageable);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(value = "/{hobby-id}/notice/search")
    public ResponseEntity<Page<HobbyArticleResponse>> searchNoticeList(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestParam(required = false) final String keyword,
            final Pageable pageable
    ){
        Page<HobbyArticleResponse> response = hobbyArticleService.findNoticeByKeyWord(userDetails.getUsername(), hobbyId, keyword, pageable);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
    /*
    # 30. 모임 게시판 게시글 조회
    */
    @GetMapping(value = "/{hobby-id}/article/{article-id}")
    public ResponseEntity<HobbyArticleDetailResponse> getArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("article-id") final Long articleId){
        HobbyArticleDetailResponse response = hobbyArticleService.findById(userDetails.getUsername(), hobbyId, articleId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/{hobby-id}/article/{article-id}")
    public ResponseEntity<Void> updateArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("article-id") final Long articleId,
            @RequestBody HobbyArticleUpdateRequest request) {
        hobbyArticleService.update(userDetails.getUsername(), articleId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/{hobby-id}/article/{article-id}")
    public ResponseEntity<Void> deleteArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("article-id") final Long articleId) {
        hobbyArticleService.delete(userDetails.getUsername(), hobbyId, articleId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}