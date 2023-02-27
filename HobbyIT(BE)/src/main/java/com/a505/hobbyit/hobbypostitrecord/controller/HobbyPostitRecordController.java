package com.a505.hobbyit.hobbypostitrecord.controller;

import com.a505.hobbyit.hobbypostitrecord.service.HobbyPostitRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Hobby Postit Record API", description = "방명록 작성 기록 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class HobbyPostitRecordController {

    private final HobbyPostitRecordService hobbyPostitRecordService;


    @Operation(
            summary = "방명록 작성 날짜 조회",
            description = "특정 소모임의 모든 방명록 작성 날짜를 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "방명록 작성 날짜 반환 성공",
                    content = @Content(examples = {
                            @ExampleObject(value = """
                                    {
                                      "dateList": [
                                        "2022-12-31",
                                        "2023-01-01",
                                        "2023-01-01",
                                        "2023-02-13",
                                        "2023-02-14",
                                        "2023-02-15",
                                        "2023-02-16"
                                      ]
                                    }
                                    """)})
            ),
            @ApiResponse(responseCode = "401", description = "방명록 작성 날짜 조회 권한이 없음", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    @GetMapping("/api/hobby/{hobby-id}/postit/record")
    ResponseEntity<Map<String, List<LocalDate>>> findHobbyPostitRecords(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") @Parameter(description = "소속 소모임 ID", example = "1") Long hobbyId
    ) {
        Map<String, List<LocalDate>> resultMap = new HashMap<>();
        List<LocalDate> regDtList = hobbyPostitRecordService.findHobbyPostitRecordRegDtList(
                Long.parseLong(userDetails.getUsername()),
                hobbyId
        );
        resultMap.put("regDtList", regDtList);
        return ResponseEntity.ok(resultMap);
    }
}
