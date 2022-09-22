package com.example.account.controller;

import com.example.account.entity.Account;
import com.example.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/create-account")
    public String createAccount() {
        accountService.createAccount();

        return "success";
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id){// 이름이 같으면 PathVariable 빼줘도댐
        return accountService.getAccount(id);
    }
}
