package com.decode.web.domain.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerCountResponseDto {

    private Long selectedCnt;
}
