package com.example.studyspringmvc.web.frontcontroller.v4;

import com.example.studyspringmvc.web.frontcontroller.ModelView;
import com.example.studyspringmvc.web.frontcontroller.MyView;
import com.example.studyspringmvc.web.frontcontroller.v3.ControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import com.example.studyspringmvc.web.frontcontroller.v4.Controller.MemberFormControllerV4;
import com.example.studyspringmvc.web.frontcontroller.v4.Controller.MemberListControllerV4;
import com.example.studyspringmvc.web.frontcontroller.v4.Controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4",urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    private Map<String, ControllerV4> controllerV4Map = new HashMap<>();

    public FrontControllerServletV4() {
        controllerV4Map.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerV4Map.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerV4Map.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV4.service");

        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerV4Map.get(requestURI);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);
        // prefix + path + suffix
        MyView view = viewResolver(viewName);

        view.render(model, request,response);
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
