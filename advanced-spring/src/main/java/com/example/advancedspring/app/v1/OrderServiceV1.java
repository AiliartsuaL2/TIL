package com.example.advancedspring.app.v1;

import com.example.advancedspring.trace.TraceStatus;
import com.example.advancedspring.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.request()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (IllegalStateException ex) {
            trace.exception(status, ex);
            // 예외를 던져주지 않으면 예외를 먹어버려서 정상으로 응답 되게 됨
            throw ex;
        }
    }
}
