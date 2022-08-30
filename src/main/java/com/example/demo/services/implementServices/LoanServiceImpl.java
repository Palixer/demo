package com.example.demo.services.implementServices;

import com.example.demo.dtos.LoanDTO;
import com.example.demo.models.Loan;
import com.example.demo.services.LoanService;
import com.example.demo.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    public List<LoanDTO> getLoans(){
        return loanRepository.findAll().stream().map(LoanDTO::new).collect(Collectors.toList());
    }

    public Loan findById(long id){
        return loanRepository.findById(id).orElse(null);
    }
}
