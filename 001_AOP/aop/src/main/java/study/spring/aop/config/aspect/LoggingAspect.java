package study.spring.aop.config.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect //이 클래스가 Aspect임을 명시
@Component // Spring Bean으로 등록
public class LoggingAspect {

    // 실제 적용할 객체,클래스 정의 ( Pointcut )
    @Pointcut("execution(* study.spring.aop.domain.hello.service.*.*(..))")
    private void serviceMethods(){}

    // Before Advice 정의
    //JoinPoint 를 통해 인자를 가져옴
    @Before("serviceMethods()")
    public void beforeLogging(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("\n--- AOP (Before) 시작 ---");
        System.out.println(">>> [LOG] Target 메서드 호출 전: " + methodName);
        System.out.println(">>> [LOG] 전달된 인자: " + args[0]);
        System.out.println("-------------------------");
    }

    // AfterReturning Advice : 결과가 성공한 값만 반환
    // RETURNING 속성을 통해 Target 이 반환한 값을 받아 처리
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterReturningLogging(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("\n--- AOP (AfterReturning) 시작 ---");
        System.out.println(">>> [LOG] Target 메서드 실행 완료: " + methodName);
        System.out.println(">>> [LOG] 반환된 결과: " + result);
        System.out.println("---------------------------------");
    }

}