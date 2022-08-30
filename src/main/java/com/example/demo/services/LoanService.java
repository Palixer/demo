package com.example.demo.services;

import com.example.demo.dtos.LoanDTO;
import com.example.demo.models.Loan;

import java.util.List;

public interface LoanService {
    public List<LoanDTO> getLoans();
    public Loan findById(long id);
}