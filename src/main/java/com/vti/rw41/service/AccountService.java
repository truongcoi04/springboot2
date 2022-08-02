package com.vti.rw41.service;

import com.vti.rw41.Entity.AccountEntity;
import com.vti.rw41.Repository.AccountRepository;
import com.vti.rw41.dto.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public AccountEntity registerAccount(AccountRequest request) {

        AccountEntity account = new AccountEntity();
        account.setEmail(request.getEmail());
        account.setPassword(request.getPassword());
        account.setFullname(request.getFullname());
        account.setBirthday(request.getBirthday());
        return accountRepository.save(account);
    }
}
