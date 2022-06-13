package com.practice.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/user/join")
    public String userPage(){
        return "/userJoin";
    }

    @PostMapping("/register")
    public void register(){

    }


}
