package com.practice.board.controller;

import com.practice.board.entity.Account;
import com.practice.board.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/account/{role}/{username}/{password}")
    public Account createAccount(@ModelAttribute Account account) {
        return service.createNew(account);
    }

}
