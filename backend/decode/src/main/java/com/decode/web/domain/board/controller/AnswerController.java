package com.decode.web.domain.board.controller;

import com.decode.web.domain.board.dto.CreateAnswerDto;
import com.decode.web.domain.board.dto.RecommendDto;
import com.decode.web.domain.board.dto.UpdateAnswerDto;
import com.decode.web.domain.board.service.AnswerService;
import com.decode.web.entity.AnswerEntity;
import com.decode.web.global.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;


    @PostMapping()
    public ResponseDto save(CreateAnswerDto createAnswerDto) {
        Long answerId = answerService.save(createAnswerDto);
        return ResponseDto.builder().status(HttpStatus.OK).message("답변 등록 성공").data(answerId)
                .build();
    }

    @PatchMapping()
    public ResponseDto update(UpdateAnswerDto updateAnswerDto) {
        AnswerEntity answer = answerService.update(updateAnswerDto);
        return ResponseDto.builder().status(HttpStatus.OK).message("답변 업데이트 성공").data(answer)
                .build();
    }

    @DeleteMapping("/{answerId}")
    public ResponseDto delete(@PathVariable Long answerId) {
        answerService.delete(answerId);
        return ResponseDto.builder().status(HttpStatus.OK).message("답변 삭제 성공").build();
    }

    @PutMapping("/{answerId}/recommend")
    public ResponseDto recommend(Long answerId, @RequestBody RecommendDto recommendDto){
        answerService.recommend(answerId, recommendDto);
        return null;
    }
}
