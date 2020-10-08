package com.playground.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {// hello/dto 응답을 처리하는 부분

    private final String name;
    private final int amount;
}
