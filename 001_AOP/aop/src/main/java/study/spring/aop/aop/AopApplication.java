package study.spring.aop.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import study.spring.aop.aop.domain.hello.service.HelloService;


/*
* @EnableAspectJAutoProxy : AOP 자동 프록시 활성화. Spring Boot 에서는 생략 가능하긴 함
* CommandLineRunner : SpringBoot 구동을 완료한 후 모든 빈이 생성되면 run () 메서드 자동 실행
* */
@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication implements CommandLineRunner {

    @Autowired
    private HelloService helloService;

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        String result = helloService.sayHello("spring");
    }
}
