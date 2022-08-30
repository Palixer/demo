package com.example.demo.services.implementServices;

import com.example.demo.dtos.AccountDTO;
import com.example.demo.models.Account;
import com.example.demo.services.AccountService;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<AccountDTO> getAccounts(){
        return accountRepository.findAll().stream().map(AccountDTO::new).collect(Collectors.toList());
    }

    @Override
    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    @Override
    public Account findById(long id){
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account findByNumber(String number){
        return accountRepository.findByNumber(number);
    }

}
