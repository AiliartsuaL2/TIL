package com.example.studyspringmvc.web.frontcontroller.v3.controller;

import com.example.studyspringmvc.domain.member.Member;
import com.example.studyspringmvc.domain.member.MemberRepository;
import com.example.studyspringmvc.web.frontcontroller.ModelView;
import com.example.studyspringmvc.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> member = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", member);
        return mv;
    }
}
