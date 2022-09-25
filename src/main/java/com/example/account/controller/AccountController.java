package com.example.account.controller;

import com.example.account.dto.AccountDto;
import com.example.account.dto.CreateAccount;
import com.example.account.dto.DeleteAccount;
import com.example.account.entity.Account;
import com.example.account.service.AccountService;
import com.example.account.service.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    @GetMapping("/get-lock")
    public String getLock(){
        return redisTestService.getLock();
    }

    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request request) {

        // accountDto => Response
        return CreateAccount.Response.toResponse(accountService.createAccount(
                request.getUserId(),
                request.getInitialBalance()
        ));
    }

    @DeleteMapping("/account")
    public DeleteAccount.Response deleteAccount(
            @RequestBody @Valid DeleteAccount.Request request) {

        // accountDto => Response
        return DeleteAccount.Response.toResponse(accountService.deleteAccount(
                request.getUserId(),
                request.getAccountNumber()
        ));
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id){// 이름이 같으면 PathVariable 빼줘도댐
        return accountService.getAccount(id);
    }
}
