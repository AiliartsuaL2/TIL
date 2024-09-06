package com.example.advancedspring.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
    public void excute() {
        long startTime = System.currentTimeMillis();
//        log.info("비즈니스 로직1 실행");
        call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    // 비즈니스 로직을 자식 클래스에서 override해서 사용
    protected abstract void call();
}
