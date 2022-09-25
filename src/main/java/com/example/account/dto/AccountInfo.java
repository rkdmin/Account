package com.example.account.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// AccountDto에 있는거를 일부 빼온거지만 구지 만든 이유는
// 프로젝트가 커질 때 복잡해진다.
public class AccountInfo {
    private String accountNumber;
    private Long balance;

    public static AccountInfo toInfo(AccountDto dto){
        return AccountInfo.builder()
                .accountNumber(dto.getAccountNumber())
                .balance(dto.getBalance())
                .build();
    }
}
