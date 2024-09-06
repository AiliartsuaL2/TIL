package com.example.advancedspring.app.v2;

import com.example.advancedspring.trace.TraceId;
import com.example.advancedspring.trace.TraceStatus;
import com.example.advancedspring.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.request()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (IllegalStateException ex) {
            trace.exception(status, ex);
            // 예외를 던져주지 않으면 예외를 먹어버려서 정상으로 응답 되게 됨
            throw ex;
        }
    }
}
