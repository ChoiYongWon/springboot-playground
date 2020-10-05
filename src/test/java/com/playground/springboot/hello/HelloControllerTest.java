package com.playground.springboot.hello;
import com.playground.springboot.hello.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)//테스트를 진행할때 인자 실행자를 실행시킴 -> JUnit과 실행자 인자 사이에 연결자 역할 
@WebMvcTest(controllers = HelloController.class)//여러 스프링 테스트 어노테이션중 WEB관련 어노테이션
public class HelloControllerTest {
    @Autowired//스프링이 관리하는 빈을 주입받음(?)
    private MockMvc mvc;//웹 API를 테스트 할때 사용 GET, POST등

    @Test//
    public void hello_returns() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))//MovkMvc를 통해 /hello로 get요청을 보냄 체이닝으로 응답 검증
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

}
