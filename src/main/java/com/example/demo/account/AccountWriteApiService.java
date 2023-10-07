package com.example.demo.account;

import com.example.demo.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.example.demo.account
 * fileName       : AccountWriteApiService
 * author         : jhw1015
 * date           : 2023/10/08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/10/08           jhw1015           최초 생성
 */
@Service
@RequiredArgsConstructor
public class AccountWriteApiService {
    private final AccountRepository accountRepository;

    public Long join(String name, int age) {
        return accountRepository.save(new Account(name,age)).getId();
    }

}
