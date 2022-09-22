package com.example.account.service;

import com.example.account.entity.Account;
import com.example.account.entity.AccountStatus;
import com.example.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor// @AutoWired대신 사용 생성자를 자동으로 만들어줌
public class AccountService {
    // @Autowired
    private final AccountRepository accountRepository;

    @Transactional
    public void createAccount(){
        Account account = Account.builder()
                .accountNumber("40000")
                .accountStatus(AccountStatus.IN_USE)
                .build();
        accountRepository.save(account);
    }

    @Transactional
    public Account getAccount(Long id){
        return accountRepository.findById(id).get();
    }
}
