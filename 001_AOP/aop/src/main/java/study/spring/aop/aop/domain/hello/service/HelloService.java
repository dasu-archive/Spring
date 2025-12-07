package study.spring.aop.aop.domain.hello.service;


import org.springframework.stereotype.Service;

@Service
public class HelloService {

    // AOP가 적용될 핵심 로직
    public String sayHello(String name) {
        return "hello, " + name;
    }
}