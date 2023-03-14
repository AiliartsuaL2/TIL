package com.example.study_springmvc_feature.basic.request;

import com.example.study_springmvc_feature.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());

        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {

        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @PostMapping("/request-body-json-v3")
    @ResponseBody
    public String requestBodyJsonV3(@RequestBody HelloData helloData){
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @PostMapping("/request-body-json-v4")
    @ResponseBody
    public HelloData requestBodyJsonV4(@RequestBody HelloData helloData){
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        return helloData; // Http 메세지 컨버터에의해 객체가 json으로 바뀜
    }
}
