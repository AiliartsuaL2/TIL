package com.example.advancedspring.app.v3;

import com.example.advancedspring.trace.TraceStatus;
import com.example.advancedspring.trace.hellotrace.HelloTraceV2;
import com.example.advancedspring.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (IllegalStateException ex) {
            trace.exception(status, ex);
            // 예외를 던져주지 않으면 예외를 먹어버려서 정상으로 응답 되게 됨
            throw ex;
        }
    }
}
