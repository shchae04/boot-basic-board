package com.practice.board.controller;


import com.practice.board.entity.Member;
import com.practice.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MemberController {


    /**
     * Constructor based Injection -> Autowired 사용하지 않음.
     */
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    public String login(Member member){
        return "userList";
    }

    @GetMapping("/list")
    public String List(){

        return "userList";
    }




    //spring security 기본 제공화면. 있어서 login.. -> ambiguous mapping error


}
