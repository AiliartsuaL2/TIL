package com.example.advancedspring.app.v5;

import com.example.advancedspring.trace.callback.TraceCallback;
import com.example.advancedspring.trace.callback.TraceTemplate;
import com.example.advancedspring.trace.logtrace.LogTrace;
import com.example.advancedspring.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    // 객체 생성을 요청마다 사용하는건 낭비 -> 최초 한 번 생성
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.excute("OrderController.request()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }
}
