package com.practice.board.service;

import com.practice.board.entity.Member;
import com.practice.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {



    private MemberRepository memberRepository;
    //회원가입 처리
    public void register(Member user){
        System.out.println("userid" + user.getUserid());
        System.out.println("userpw" + user.getUserpw());
        System.out.println("username" + user.getUsername());

        //Spring security
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();

        user.setUserpw(pwEncoder.encode(user.getUserpw()));

        //userid,username,pw
        System.out.println("userid: " + user.getUserid());
        System.out.println("username: " + user.getUsername());
        System.out.println("암호화된 userpw: " + user.getUserpw());
        //스프링 시큐리티로 암호화 처리해야함.

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        //스프링 시큐리티 적용을 위해서 새로운 프로젝트를 생성한다.
        //프로젝트를 생성후 board와 user를 통합해서 -> board - user 사이트를 생성한다. 완전하게 ...

        String newPw = encoder.encode(user.getUserpw());

        user.setUserpw(newPw);

        memberRepository.save(user);

    }

    public List<Member> getList(){
       return memberRepository.findAll();
    }

}
