package com.playground.springboot.hello.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//JSON을 반환하는 컨트롤러로 변환시켜주는 어노테이션
public class HelloController {
    @GetMapping("/hello")//GET요청을 받을수 있는 API를 만들어주는 어노테이션
    public String hello(){
        return "hello";
    }
}
