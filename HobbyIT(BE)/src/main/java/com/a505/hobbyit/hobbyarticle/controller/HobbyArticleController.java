package com.a505.hobbyit.hobbyarticle.controller;

import com.a505.hobbyit.hobbyarticle.dto.*;
import com.a505.hobbyit.hobbyarticle.service.HobbyArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
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

    @PostMapping(value = "/{hobby-id}/article")
    public ResponseEntity<Void> saveArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestPart(value = "request") final HobbyArticleRequest request,
            @RequestParam(value = "multipartFile") List<MultipartFile> multipartFile
            ){
        log.info(request.getTitle() + " " + request.getContent() + " " + request.getCategory());
        log.info("file size is : "+ multipartFile.size());
        hobbyArticleService.saveArticle(userDetails.getUsername(), hobbyId, request, multipartFile);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/{hobby-id}/notice")
    public ResponseEntity<Void> saveNotice(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestBody final HobbyNoticeRequest request){
        hobbyArticleService.saveNotice(userDetails.getUsername(), hobbyId, request);
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
    public ResponseEntity<Page<HobbyNoticeResponse>> getNoticeList(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
             final Pageable pageable
    ){
        Page<HobbyNoticeResponse> response = hobbyArticleService.findAllNotice(userDetails.getUsername(), hobbyId, pageable);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(value = "/{hobby-id}/notice/search")
    public ResponseEntity<Page<HobbyNoticeResponse>> searchNoticeList(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestParam(required = false) final String keyword,
            final Pageable pageable
    ){
        Page<HobbyNoticeResponse> response = hobbyArticleService.findNoticeByKeyWord(userDetails.getUsername(), hobbyId, keyword, pageable);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(value = "/{hobby-id}/notice/{notice-id}")
    public ResponseEntity<HobbyNoticeResponse> getNotice(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("notice-id") final Long noticeId){
        HobbyNoticeResponse response = hobbyArticleService.getNotice(userDetails.getUsername(), hobbyId, noticeId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
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
