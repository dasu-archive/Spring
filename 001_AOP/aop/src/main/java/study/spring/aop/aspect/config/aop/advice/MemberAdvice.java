package study.spring.aop.aspect.config.aop.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MemberAdvice {

    @Pointcut("@within(study.spring.aop.aspect.config.aop.annotation.MemberDomain)")
    public void memberDomain(){}

    @Around("memberDomain()")
    public Object logMember(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[MEMBER DOMAIN] " + pjp.getSignature());
        return pjp.proceed();
    }
}
