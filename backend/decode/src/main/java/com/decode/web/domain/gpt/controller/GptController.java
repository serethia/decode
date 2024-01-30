package com.decode.web.domain.gpt.controller;

import com.decode.web.domain.gpt.dto.GptApiRequestDto;
import com.decode.web.domain.gpt.dto.GptApiResponseDto;
import com.decode.web.domain.gpt.service.GptApiServiceImpl;
import com.decode.web.global.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpt")
@RequiredArgsConstructor
public class GptController {

    private final GptApiServiceImpl gptApiService;

    @PostMapping
    public ResponseDto generateGptAnswer(@RequestBody GptApiRequestDto gptApiDto) {
        GptApiResponseDto gptApiResponseDto = new GptApiResponseDto();
        gptApiResponseDto.setTagIds(gptApiService.keywordsByError(gptApiDto.getContent()));
        gptApiResponseDto.setTitles(gptApiService.titlesByError(gptApiDto.getContent()));
        
        return ResponseDto.builder()
                .status(HttpStatus.OK)
                .message("GPT 추천 완료")
                .data(gptApiResponseDto)
                .build();
    }

}
