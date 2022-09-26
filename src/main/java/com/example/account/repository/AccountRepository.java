package com.example.account.repository;

import com.example.account.entity.Account;
import com.example.account.entity.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // 내림차순 정렬 후 맨 위의 계좌
    Optional<Account> findFirstByOrderByIdDesc();// 값이 없을수도 있기에 Optional

    Integer countByAccountUser(AccountUser accountUser);

    Optional<Account> findByAccountNumber(String AccountNumber);

    List<Account> findByAccountUser(AccountUser accountUser);


}
