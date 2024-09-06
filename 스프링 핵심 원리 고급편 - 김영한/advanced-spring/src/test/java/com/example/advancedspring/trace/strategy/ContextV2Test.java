package com.example.advancedspring.trace.strategy;

import com.example.advancedspring.trace.strategy.code.strategy.ContextV1;
import com.example.advancedspring.trace.strategy.code.strategy.ContextV2;
import com.example.advancedspring.trace.strategy.code.strategy.Strategy;
import com.example.advancedspring.trace.strategy.code.strategy.StrategyLogic1;
import com.example.advancedspring.trace.strategy.code.strategy.StrategyLogic2;
import com.example.advancedspring.trace.template.code.AbstractTemplate;
import com.example.advancedspring.trace.template.code.SubClassLogic1;
import com.example.advancedspring.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        // 파라미터로 전달
        context.excute(new StrategyLogic1());
        context.excute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        // 파라미터로 전달
        context.excute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        // 파라미터로 전달
        context.excute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 전략 패턴 익명 내부 클래스 , 람다 사용
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        // 파라미터로 전달
        context.excute(() -> log.info("비즈니스 로직1 실행"));
        // 파라미터로 전달
        context.excute(() -> log.info("비즈니스 로직2 실행"));
    }
}
