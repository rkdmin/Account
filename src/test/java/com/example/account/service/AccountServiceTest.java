package com.example.account.service;

import com.example.account.entity.Account;
import com.example.account.type.AccountStatus;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock// 가짜를 만들어줌
    private AccountRepository accountRepository;

    @InjectMocks// 가짜로 만든 repository를 inject해줌
    private AccountService accountService;

//    @BeforeEach// 테스트 전에 동작하는 메소드
//    void init(){
//        accountService.createAccount();
//    }

    @Test
    @DisplayName("계좌 조회 성공")// 이름 설정
    void getAccount(){
        // given
        given(accountRepository.findById(anyLong()))
                .willReturn(Optional.of(Account.builder()
                        .accountStatus(AccountStatus.UNREGISTERED)
                        .accountNumber("65789").build()));

        // when
        Account account = accountService.getAccount(1234L);

        // then
        assertEquals("65789", account.getAccountNumber());
        assertEquals(AccountStatus.UNREGISTERED, account.getAccountStatus());
    }

}