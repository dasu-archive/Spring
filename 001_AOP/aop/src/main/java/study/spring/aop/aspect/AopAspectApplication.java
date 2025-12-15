package study.spring.aop.aspect;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.spring.aop.aspect.domain.member.service.MemberService;

@SpringBootApplication
public class AopAspectApplication implements CommandLineRunner {

    @Autowired
    private MemberService memberService;

    public static void main(String[] args) {
        SpringApplication.run(AopAspectApplication.class, args);
    }

    @Override
    public void run(String... args)  {
        memberService.getMember();
    }
}

