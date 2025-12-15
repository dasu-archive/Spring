package study.spring.aop.aspect.domain.member.service;


import org.springframework.stereotype.Service;
import study.spring.aop.aspect.config.aop.annotation.MemberDomain;

@MemberDomain
@Service
public class MemberService {
    public void getMember(){
        System.out.println("Member Study");
    }
}
