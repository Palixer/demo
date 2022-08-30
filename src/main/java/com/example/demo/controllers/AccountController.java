package com.example.demo.controllers;

import com.example.demo.dtos.AccountDTO;
import com.example.demo.models.Account;
import com.example.demo.models.Client;
import com.example.demo.services.AccountService;
import com.example.demo.services.ClientService;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    ClientService clientService;
    @Autowired
    TransactionService transactionService;

    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts() {
        List<AccountDTO> accounts = accountService.getAccounts();
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public AccountDTO getAccount(@PathVariable long id) {
        AccountDTO account = new AccountDTO(accountService.findById(id));
        return account;
    }

    @PostMapping("/clients/current/accounts")
    public ResponseEntity<Object> createAccount(Authentication authentication) {
        Client client = clientService.findClientByEmail(authentication.getName());
        List<Account> accounts = new ArrayList<>();


        if (accounts.size() == 3) {
            return new ResponseEntity<>("Client can't have more than three accounts", HttpStatus.FORBIDDEN);
        }
        return null;

    }
}