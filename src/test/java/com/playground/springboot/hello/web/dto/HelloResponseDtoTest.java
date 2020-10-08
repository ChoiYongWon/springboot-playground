package com.playground.springboot.hello.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_test(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount); //HelloRespenseDto 인스턴스 생성

        assertThat(dto.getName()).isEqualTo(name);//assertThat : 검증 메소드, isEqualTo : 확인메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
