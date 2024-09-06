package com.example.advancedspring.trace;

import java.util.UUID;
import lombok.Getter;

@Getter
public class TraceId {
    // 트랜잭션 ID
    private String id;
    // 깊이
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        // abcdefgh - asdfsaf - asdfasdf- asdf...
        // abcdefgh 만 사용
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // 다음 깊이의 객체 생성자
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
}
