package com.example.studyspringmvc.web.frontcontroller.v3;

import com.example.studyspringmvc.web.frontcontroller.ModelView;
import com.example.studyspringmvc.web.frontcontroller.MyView;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public FrontControllerServletV3() {
        controllerV3Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerV3Map.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerV3Map.get(requestURI);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();
        // prefix + path + suffix
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), request,response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    // 위의 작업들은 크게크게 작업이 되는데 하기 메서드는 디테일한 로직이므로 메서드를 따로 뽑음
    private static Map<String, String> createParamMap(HttpServletRequest request) {
        //request의 모든 파라미터를 paramMap에 넣어줌
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
