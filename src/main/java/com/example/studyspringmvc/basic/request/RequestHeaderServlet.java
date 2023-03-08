package com.example.studyspringmvc.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printHeaders(request);

        /**
         * 파라미터의 name이 중복된경우 덮어 씌어지진 않고, 먼저 작성된 파라미터가 나오게 되어있음,
         * 두 값을 모두 꺼내고싶은경우 getParameterValues사용
         */
        String[] usernames = request.getParameterValues("username"); // 이런식으로 배열로 꺼내짐
        for (String username : usernames) {
            System.out.println("username = " + username);
        }

    }

    private void printHeaders(HttpServletRequest request){
        System.out.println("--- Headers - start ---");

        // 옛날방식의 헤더 출력하는 방법
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName +"= " + request.getHeader(headerName));
        }


        // 요즘스타일
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println(headerName +"= " +  request.getHeader(headerName)));
        System.out.println("--- Headers - end ---");
    }


}
