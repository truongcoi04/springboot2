package com.vti.rw41.service;

import com.vti.rw41.Entity.AccountEntity;
import com.vti.rw41.Entity.Department;
import com.vti.rw41.Entity.Product;
import com.vti.rw41.Repository.AccountRepository;
import com.vti.rw41.Repository.DepartmentRepository;
import com.vti.rw41.Repository.ProductRepository;
import com.vti.rw41.dto.AccountRequest;
import com.vti.rw41.exeption.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Transactional
    public AccountEntity registerAccount(AccountRequest request) {

        AccountEntity account = new AccountEntity();
        account.setEmail(request.getEmail());
        String encode = passwordEncoder.encode(request.getPassword());
        account.setPassword(encode);
        account.setFullName(request.getFullName());
        account.setBirthday(request.getBirthday());
        accountRepository.save(account);

//        Product product = new Product();
//        product.setName("Tôi là người máy");
//        product.setPrice(5.0);
//        productRepository.save(product);

        return account;
    }


    public Optional<AccountEntity> getAccountById(Integer accountId) {
        Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
        if (accountEntity.isEmpty()) {
            throw new ApiException("Account.not.exists");
        }
        return accountEntity;
    }

    public List<AccountEntity> getAccountByName(String name) {
        return accountRepository.timAccountTheoTen("%" + name + "%"); //hoặc accountRepository.findByFullNameLike
    }

    public Page<AccountEntity> getAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }






}
