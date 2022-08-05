package com.vti.rw41.controller;

import com.vti.rw41.Entity.AccountEntity;
import com.vti.rw41.dto.AccountRequest;
import com.vti.rw41.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.OpenDataException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AccountEntity registerAccount(@Valid @RequestBody AccountRequest request) {
        return accountService.registerAccount(request);
    }
    @GetMapping("/{accountId}")
    public Optional<AccountEntity> getAccountById(@PathVariable Integer accountId){
        return accountService.getAccountById(accountId);
    }
    @GetMapping("/like/{name}")
    public List<AccountEntity> getAccountById(@PathVariable String name){
        return accountService.getAccountByName(name);
    }

    @GetMapping
    public Page<AccountEntity> getAllAccounts(Pageable pageable){
        return accountService.getAllAccounts(pageable);
    }



}
