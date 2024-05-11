package com.example.advancedspring.app.v3;

import com.example.advancedspring.trace.TraceId;
import com.example.advancedspring.trace.TraceStatus;
import com.example.advancedspring.trace.hellotrace.HelloTraceV2;
import com.example.advancedspring.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace trace;
    public void save(TraceId traceId, String itemId) {
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
