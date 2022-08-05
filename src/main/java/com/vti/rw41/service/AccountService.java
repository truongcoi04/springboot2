package com.vti.rw41.service;

import com.vti.rw41.Entity.AccountEntity;
import com.vti.rw41.Entity.Department;
import com.vti.rw41.Repository.AccountRepository;
import com.vti.rw41.Repository.DepartmentRepository;
import com.vti.rw41.dto.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    @Transactional
    public AccountEntity registerAccount(AccountRequest request) {

        AccountEntity account = new AccountEntity();
        account.setEmail(request.getEmail());
        account.setPassword(request.getPassword());
        account.setFullName(request.getFullName());
        account.setBirthday(request.getBirthday());
        AccountEntity save = accountRepository.save(account);

        Department department = new Department();
        department.setDepartmentName("Test transactional");
        departmentRepository.save(department);

        return account;
    }


    public Optional<AccountEntity> getAccountById(Integer accountId) {
        return accountRepository.findById(accountId);
    }

    public List<AccountEntity> getAccountByName(String name) {
        return accountRepository.timAccountTheoTen("%" + name + "%"); //hoặc accountRepository.findByFullNameLike
    }

    public Page<AccountEntity> getAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }


}
