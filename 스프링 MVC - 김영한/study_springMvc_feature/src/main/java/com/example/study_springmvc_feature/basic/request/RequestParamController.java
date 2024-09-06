package com.example.study_springmvc_feature.basic.request;

import com.example.study_springmvc_feature.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int age = Integer.parseInt(request.getParameter("age"));
        String username = request.getParameter("username");

        log.info("username={}, age={}",username,age);

        response.getWriter().write("ok");
    }

    @RequestMapping("/request-param-v2")
    @ResponseBody
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){

        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }

    @RequestMapping("/request-param-v3")
    @ResponseBody
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age){
        // 쿼리파라미터의 키와 변수명이 같으면 @RequestParam의 속성 생략 가능
        // String,int,Integer같은 단순 타입이면 @RequestParam 자체도 생략 가능
        // 애노테이션을 이렇게 완전히 생략하면 직관적인게 없어지기 때문에, 유지보수 관점에서 어려움
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @RequestMapping("/request-param-required")
    @ResponseBody
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            //@RequestParam(required = false, defaultValue = "-1") int age){
            @RequestParam(required = false) Integer age){
        // required false주면 값이 없어도 회출이 되는데,
        // 값이 없으면 해당 변수에 null이 할당됨
        // 하지만 age는 현재 primitive(int) 타입이기 때문에 null이 들어 갈 수 없음
        // IllegalStateException 발생하면서 500에러 발생
        // 따라서 박스타입으로 받거나 defaultValue 속성을 추가해주어야 함

        // 또한 name만 있고, 값을 안넣으면 통과되는데 null이아닌 빈문자로 들어옴
            // 이 때 defaultValue 속성을 추가하면 빈문자도 처리 해줌

        // 쿼리파라미터의 키와 변수명이 같으면 @RequestParam의 속성 생략 가능
        // String,int,Integer같은 단순 타입이면 @RequestParam 자체도 생략 가능
        // 애노테이션을 이렇게 완전히 생략하면 직관적인게 없어지기 때문에, 유지보수 관점에서 어려움

        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @RequestMapping("/request-param-map")
    @ResponseBody
    public String requestParamV3(@RequestParam Map<String,Object> paramMap){
        // 쿼리파라미터의 키와 변수명이 같으면 @RequestParam의 속성 생략 가능
        // String,int,Integer같은 단순 타입이면 @RequestParam 자체도 생략 가능
        // 애노테이션을 이렇게 완전히 생략하면 직관적인게 없어지기 때문에, 유지보수 관점에서 어려움
        log.info("username={}, age={}",paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
