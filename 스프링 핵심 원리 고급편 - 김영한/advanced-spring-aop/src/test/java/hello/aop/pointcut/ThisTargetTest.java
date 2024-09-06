package hello.aop.pointcut;

import hello.aop.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * spring.aop.proxy-target-class=true CGLIB (Default)
 * spring.aop.proxy-target-class=false JDK 동적 프록시
 */

// JDK 동적 프록시
//@SpringBootTest(properties = "spring.aop.proxy-target-class=false")

// CGLIB
@SpringBootTest(properties = "spring.aop.proxy-target-class=true")
@Slf4j
@Import(ThisTargetTest.ThisTargetAspect.class)
public class ThisTargetTest {

    @Autowired
    MemberService memberService;

    @Test
    void success() {
        log.info("memberService Proxy={}", memberService.getClass());
        memberService.hello("helloA");
    }

    @Aspect
    @Slf4j
    static class ThisTargetAspect {

        // 부모 타입 허용
        @Around("this(hello.aop.member.MemberService)")
        public Object doThisInterface(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            log.info("[this-interface] {}", proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed();
        }

        // 부모 타입 허용
        @Around("target(hello.aop.member.MemberService)")
        public Object doTargetInterface(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            log.info("[target-interface] {}", proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed();
        }

        // 부모 타입 허용
        // Impl을 모르기 때문에 적용이 되지 않음.
        @Around("this(hello.aop.member.MemberServiceImpl)")
        public Object doThis(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            log.info("[this-impl] {}", proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed();
        }

        // 부모 타입 허용
        @Around("target(hello.aop.member.MemberServiceImpl)")
        public Object doTarget(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            log.info("[target-impl] {}", proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed();
        }
    }
}
