package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Slf4j
//@Component
//public class CallServiceV1 {
//
//    // 빈 생성자 주입시 순환 참조 문제가 생김
//    private CallServiceV1 callServiceV1;
//
//    // -> Setter 주입 사용해야함...
//    // -> 스프링 부트 2.6 버전부터는 순환 참조를 기본적으로 금지하도록 변경,, property 설정 추가해야함
//    @Autowired
//    public void setCallServiceV1(CallServiceV1 callServiceV1) {
//        this.callServiceV1 = callServiceV1;
//    }
//
//    public void external() {
//        log.info("call external");
//        // 외부(자기 자신을 DI 받은 객체로 -> 해당 객체는 프록시 객체)
//        callServiceV1.internal();
//    }
//
//    public void internal() {
//        log.info("call internal");
//    }
//}
