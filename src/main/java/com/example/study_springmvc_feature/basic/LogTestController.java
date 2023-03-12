package com.example.study_springmvc_feature.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {


    //private final Logger log = LoggerFactory.getLogger(getClass()); // 롬복으로 대체 가능

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        log.trace("trace log={}", name); // 치환이 된다
        log.debug("debug log={}", name);
        log.info(" info log = {}",name);
        log.warn("warn log = {}", name);
        log.error("error log = {}",name);
        //log.error("error log = "+ name); // 이렇게 더하기 하면 안됨, 메모리에서 미리 연산을 해버리기 때문에;;
        //


        return "ok";
    }
}
