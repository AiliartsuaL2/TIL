package com.example.studyspringmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 공통 관심 사항 (cross-cutting concern)
 *  - 비즈니스 로직이 아닌, 공통적으로 수행하는 사항
 *  - 예를들어 회원가입, 회원 목록 조회 등의 메서드의 시간을 측정하는 기능,,
 * 핵심 관심 사항 (core concern)
 *  - 핵심적인 비즈니스 로직
 *
 *
 *  스프링에서 제공하는 Aop
 * - 빈 등록을 해야하는데 컴포넌트 스캔방식보다 설정쪽에 따로 해주는것이 좋음(공통 사용 빈이기 때문에)
 * - 메서드를 실행하기전, 하면서, 하고나서 특정 작업을 실행시킬 수 있는 기술
 */

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.example.studyspringmvc..*(..))") // 적용 범위 설정
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START :  " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("timeMs :  " + timeMs);
        }

    }
}
