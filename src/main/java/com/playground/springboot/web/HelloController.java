package com.playground.springboot.web;
import com.playground.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//JSON을 반환하는 컨트롤러로 변환시켜주는 어노테이션
public class HelloController {
    @GetMapping("/hello")//GET 요청을 받을수 있는 API를 만들어주는 어노테이션
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name, @RequestParam("amount") int amount){// RequestParam으로 피라미터 파싱
        return new HelloResponseDto(name, amount);
    }
}
