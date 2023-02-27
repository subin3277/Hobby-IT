package com.a505.hobbyit.article.controller;

import com.a505.hobbyit.article.dto.ArticleRequest;
import com.a505.hobbyit.article.dto.ArticleResponse;
import com.a505.hobbyit.article.dto.OwnHobbyResponse;
import com.a505.hobbyit.article.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Article API", description = "홍보 게시판 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;


    @Operation(
            summary = "홍보 게시판 게시글 등록",
            description = "로그인 사용자 정보, 홍보할 소모임 ID, 작성할 내용을 이용하여 게시글을 등록합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "게시글 등록 성공"),
            @ApiResponse(responseCode = "401", description = "게시글 작성 권한이 없음", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    @PostMapping("/{hobby-id}")
    ResponseEntity<Void> createArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") @Parameter(description = "홍보할 모임 ID", example = "1") Long hobbyId,
            @RequestBody @Parameter(description = "게시할 글의 정보") ArticleRequest articleRequest
    ) {
        articleService.save(Long.parseLong(userDetails.getUsername()), hobbyId, articleRequest);
        return ResponseEntity.ok().build();
    }


    @Operation(
            summary = "홍보 게시판 게시글 페이지 조회",
            description = "각 페이지 당 10개씩 글을 조회합니다."
    )
    @ApiResponse(responseCode = "200", description = "게시글 페이지 반환 성공")
    @GetMapping
    ResponseEntity<Page<ArticleResponse>> findArticlesByPageRequest(
            @Parameter(description = "페이지 번호", example = "0")
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<ArticleResponse> articleResponsePage = articleService.findArticlesByPageRequest(pageable);
        return ResponseEntity.ok(articleResponsePage);
    }


    @Operation(
            summary = "홍보 게시판 게시글 상세 조회",
            description = "조회할 글의 ID를 이용하여 게시글을 상세 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "게시글 상세 조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    @GetMapping("/{article-id}")
    ResponseEntity<ArticleResponse> findArticle(
            @PathVariable("article-id") @Parameter(description = "조회할 글의 ID", example = "1") Long articleId,
            HttpServletRequest request, HttpServletResponse response
    ) {
        ArticleResponse articleResponse = articleService.findById(articleId, request, response);
        return ResponseEntity.ok(articleResponse);
    }


    @Operation(
            summary = "홍보 게시판 페이지 수 반환",
            description = "홍보 게시판의 페이지 수를 반환합니다."
    )
    @ApiResponse(responseCode = "200", description = "홍보 게시판 페이지 수 반환 성공",
            content = @Content(examples =
                    {@ExampleObject(value = "pageCnt : 4")}
            )
    )
    @GetMapping("/page")
    ResponseEntity<Map<String, Long>> find() {
        final int PAGEABLE_SIZE = 10;
        Map<String, Long> resultMap = new HashMap<>();
        long pageCnt = articleService.count();
        resultMap.put("pageCnt", pageCnt / PAGEABLE_SIZE + (pageCnt % PAGEABLE_SIZE == 0 ? 0 : 1));
        return ResponseEntity.ok(resultMap);
    }


    @Operation(
            summary = "홍보 게시판 게시글 수정",
            description = "로그인 사용자 정보, 수정할 글의 ID, 수정할 내용을 이용하여 게시글을 수정합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "게시글 수정 성공"),
            @ApiResponse(responseCode = "401", description = "게시글 수정 권한이 없음", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    @PutMapping("/{article-id}")
    ResponseEntity<Void> updateArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("article-id") @Parameter(description = "수정할 글의 id", example = "1") Long articleId,
            @RequestBody @Parameter(description = "수정할 글의 정보") ArticleRequest articleRequest
    ) {
        articleService.update(Long.parseLong(userDetails.getUsername()), articleId, articleRequest);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "홍보 게시판 게시글 삭제",
            description = "로그인 사용자 정보, 삭제할 글의 ID를 이용하여 게시글을 삭제합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "게시글 삭제 성공"),
            @ApiResponse(responseCode = "401", description = "게시글 삭제 권한이 없음", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    @DeleteMapping("/{article-id}")
    ResponseEntity<Void> deleteArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("article-id") @Parameter(description = "삭제할 글의 id", example = "1") Long articleId
    ) {
        articleService.deleteById(Long.parseLong(userDetails.getUsername()), articleId);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "'소유자' 권한을 가진 소모임 리스트를 반환",
            description = "로그인 사용자 정보를 이용하여 '소유자' 권한을 가진 소모임 리스트를 반환합니다."
    )
    @ApiResponse(responseCode = "200", description = "'소유자' 권한을 가진 소모임 리스트를 반환 성공",
            content = @Content(examples =
                    {@ExampleObject(
                            value = """
                                    {
                                        "ownHobbyList": [
                                            {
                                                 "id": 1,
                                                 "name": "john, 나 여행가고싶어"\s
                                            },\s
                                        ]
                                    }"""
                    )}
            )
    )
    @GetMapping("/possession")
    public ResponseEntity<Map<String, List<OwnHobbyResponse>>> getOwnHobby(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        Map<String, List<OwnHobbyResponse>> resultMap = new HashMap<>();
        List<OwnHobbyResponse> responses = articleService.getOwnHobbyList(Long.parseLong(userDetails.getUsername()));
        resultMap.put("ownHobbyList", responses);
        return ResponseEntity.ok(resultMap);
    }
}
