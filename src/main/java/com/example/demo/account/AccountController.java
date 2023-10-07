package com.example.demo.account;


import com.example.demo.account.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountWriteApiService accountWriteApiService;
    @PostMapping("/join")
    public Long join(@RequestBody AccountDto.JoinRequest joinRequest) {
        return accountWriteApiService.join(joinRequest.getName(),joinRequest.getAge());
    }

}
