package com.practice.board.controller;

import com.practice.board.entity.Member;
import com.practice.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private MemberService userService;

    @GetMapping("/user/join")
    public String userPage(){
        return "userJoin";
    }

    @PostMapping("/register")
    public void register(Member user, Model model){
        System.out.println("user 회원가입 요청");

        userService.register(user);
    }

    //login access 처리
    @GetMapping("user/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public void makesession(HttpSession session){
        session.setAttribute("login","login_user");
        String aar = (String)session.getAttribute("login");
    }

}
