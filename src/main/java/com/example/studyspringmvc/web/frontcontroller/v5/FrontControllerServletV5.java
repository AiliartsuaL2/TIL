package com.example.studyspringmvc.web.frontcontroller.v5;

import com.example.studyspringmvc.web.frontcontroller.ModelView;
import com.example.studyspringmvc.web.frontcontroller.MyView;
import com.example.studyspringmvc.web.frontcontroller.v3.ControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v4.Controller.MemberFormControllerV4;
import com.example.studyspringmvc.web.frontcontroller.v4.Controller.MemberListControllerV4;
import com.example.studyspringmvc.web.frontcontroller.v4.Controller.MemberSaveControllerV4;
import com.example.studyspringmvc.web.frontcontroller.v5.adapter.ControllerV3HandlerAdpater;
import com.example.studyspringmvc.web.frontcontroller.v5.adapter.ControllerV4HandlerAdpater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }


    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //V4
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }


    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdpater());
        handlerAdapters.add(new ControllerV4HandlerAdpater());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object handler = getHandler(request); // 핸들러 호출

        if(handler == null){ // 핸들러 없으면 404
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler); // 어댑터확인

        ModelView mv = adapter.handle(request, response, handler);


        String viewName = mv.getViewName();
        // prefix + path + suffix
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), request,response);

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(handler)){
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler = "+handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);

    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

}
