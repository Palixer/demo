package com.example.demo.controllers;

import com.example.demo.dtos.LoanApplicationDTO;
import com.example.demo.dtos.LoanDTO;
import com.example.demo.models.Account;
import com.example.demo.models.Client;
import com.example.demo.models.ClientLoan;
import com.example.demo.models.Loan;
import com.example.demo.repositories.*;
import com.mindhub.homebanking.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import java.util.stream.Collectors;



@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientLoanRepository clientLoanRepository;
    @Autowired
    private LoanRepository loanRepository;



    @GetMapping("/loans")
    public List<LoanDTO> getLoans(){
        return loanRepository.findAll().stream().map(loan -> new LoanDTO(loan)).collect(Collectors.toList());
        //encuentra todos los LOANs y usa el stream y el map para convertirlos en LOANDTO
    }


    @Transactional
    @PostMapping("/loans")
    public ResponseEntity<Object> createClientLoan(@RequestBody LoanApplicationDTO loanApplicationDTO, Authentication authentication){

        Loan loanFind = this.loanRepository.findById(loanApplicationDTO.getId()).orElse(null); //guardo la info del prestamo en una variable
        Account accountFind = this.accountRepository.findByNumber(loanApplicationDTO.getToAccountNumber());
        Client clientFind = this.clientRepository.findByEmail(authentication.getName());

        if(loanApplicationDTO.getId()==0){
            return new ResponseEntity<>("Not an available ID", HttpStatus.FORBIDDEN);
        }

        if(loanApplicationDTO.getAmount()==0 || loanApplicationDTO.getAmount()>loanFind.getMaxAmount()){
            return new ResponseEntity<>("Exceeds the maximum available", HttpStatus.FORBIDDEN);
        }

        if(!loanFind.getPayments().contains(loanApplicationDTO.getPayments())){
            return new ResponseEntity<>("Not an available amount of payments", HttpStatus.FORBIDDEN);
        }

        /*
        if(loan == null){
            return new ResponseEntity<>("Loan not available", HttpStatus.FORBIDDEN);
        } ;//verifica que no esa null y sino sigue
        */
        if(accountFind.getNumber().isEmpty()){
            return new ResponseEntity<>("In Account", HttpStatus.FORBIDDEN);
        }

        /*
        if(loanApplicationDTO.getAmount()>loan.getMaxAmount()){
            return new ResponseEntity<>("Exceeds the maximum available", HttpStatus.FORBIDDEN);
        }*/


        ClientLoan newClientLoan= new ClientLoan(loanApplicationDTO.getAmount()+(loanApplicationDTO.getAmount()*20/100),loanApplicationDTO.getPayments(),clientFind,loanFind);
        clientLoanRepository.save(newClientLoan);

        accountFind.setBalance(accountFind.getBalance()+loanApplicationDTO.getAmount());
        accountRepository.save(accountFind);
        return new ResponseEntity<>("Transaccion realizada con exito", HttpStatus.CREATED);

}


}


