package com.practice.board.service;

import com.practice.board.entity.User;
import com.practice.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    //회원가입 처리
    public void register(User user){
        System.out.println("userid" + user.getUserid());
        System.out.println("userpw" + user.getUserpw());
        System.out.println("username" + user.getUsername());

        //스프링 시큐리티로 암호화 처리해야함.
        userRepository.save(user);

    }

}
