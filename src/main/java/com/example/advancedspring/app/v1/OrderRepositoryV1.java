package com.example.advancedspring.app.v1;

import com.example.advancedspring.trace.TraceStatus;
import com.example.advancedspring.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final HelloTraceV1 trace;
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.request()");

            // 저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생 !");
            }
            sleep(1000);

            trace.end(status);
        } catch (IllegalStateException ex) {
            trace.exception(status, ex);
            // 예외를 던져주지 않으면 예외를 먹어버려서 정상으로 응답 되게 됨
            throw ex;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
