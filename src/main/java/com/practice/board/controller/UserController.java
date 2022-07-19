package com.practice.board.controller;

import com.practice.board.entity.User;
import com.practice.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/join")
    public String userPage(){
        return "/userJoin";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.register(user);

        return "redirect:/userJoin";
    }


}
