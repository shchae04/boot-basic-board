package com.practice.board.controller;

import com.practice.board.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/join")
    public String userPage(){
        return "userJoin";
    }

    @PostMapping("/register")
    public void register(){

    }

    //login access 처리
    @GetMapping("user/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public void makesession(HttpSession session){
        session.setAttribute("login","login_user");
    }


}
