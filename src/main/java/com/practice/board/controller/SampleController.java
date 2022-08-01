package com.practice.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/*
    principal은 자바의 표준 시큐리티 -> 계정정보를 담고있다.
    문제점.
    1. 로그인 방법이 없다.
    2. 사용자를 알아낼 방법이 없다.
 */

@Controller
public class SampleController {

    @GetMapping("/main")
    public String index(Model model, Principal principal) {
        if(principal == null) {
            model.addAttribute("message","Hello Spring Security");
        } else  {
            model.addAttribute("message","Hello " + principal.getName());
        }
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message","Hello Info");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message","Hello " + principal.getName());
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Hello Admin, " + principal.getName());
        return "admin";
    }
}
