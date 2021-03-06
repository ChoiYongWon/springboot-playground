package com.playground.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)//테스트를 진행할때 인자 실행자를 실행시킴 -> JUnit과 실행자 인자 사이에 연결자 역할 
@WebMvcTest(controllers = HelloController.class)//여러 스프링 테스트 어노테이션중 WEB관련 어노테이션
public class HelloControllerTest {
    @Autowired//스프링이 관리하는 빈을 주입받음(?)
    private MockMvc mvc;//웹 API를 테스트 할때 사용 GET, POST등

    @Test//
    public void hello_returns() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))//MovkMvc를 통해 /hello로 get 요청을 보냄 체이닝으로 응답 검증
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto_returns() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto").param("name", name)
                .param("amount", String.valueOf(amount))// params 메소드로 요청에 피라미터 추가
        )
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.name",is(name)))//JSON 응답값을 필드별로 검증할 수 있는 메소드 $.을 기준으로 필드명 명시
           .andExpect(jsonPath("$.amount", is(amount)));
    }

}
