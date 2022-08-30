package com.example.demo.services;

import com.example.demo.dtos.AccountDTO;
import com.example.demo.models.Account;

import java.util.List;

public interface AccountService {
    public List<AccountDTO> getAccounts();
    public Account saveAccount(Account account);
    public Account findById(long id);
    public Account findByNumber(String number);
}
