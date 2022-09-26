package com.example.account.controller;

import com.example.account.dto.AccountDto;
import com.example.account.dto.AccountInfo;
import com.example.account.dto.CreateAccount;
import com.example.account.dto.DeleteAccount;
import com.example.account.entity.Account;
import com.example.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    /**
     * 계좌 생성
     */
    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request request) {

        // accountDto => Response
        return CreateAccount.Response.toResponse(accountService.createAccount(
                request.getUserId(),
                request.getInitialBalance()
        ));
    }

    /**
     * 계좌 삭제
     */
    @DeleteMapping("/account")
    public DeleteAccount.Response deleteAccount(
            @RequestBody @Valid DeleteAccount.Request request) {

        // accountDto => Response
        return DeleteAccount.Response.toResponse(accountService.deleteAccount(
                request.getUserId(),
                request.getAccountNumber()
        ));
    }

    /**
     * 계좌 확인
     */
    @GetMapping("/account")
    public List<AccountInfo> getAccountsByUserId(
            @RequestParam("user_id") Long userId){

        return accountService.getAccountsByUserId(userId).stream()
                .map(accountDto -> AccountInfo.toInfo(accountDto))
                .collect(Collectors.toList());// info 로바꾸고 다시 List로 변환
    }
}
