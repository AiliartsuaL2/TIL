package com.example.study_springmvc_feature.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap, // 모든 헤더들이 들어옴,,
                          // MultiValueMap : Map과 유사한데, 하나의 키에 여러 값을 받을 수 있음,, 같은 키에 배열로 저장이됨!
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false) String cookie){
        log.info("request={}",request);
        return "ok";

    }
}
