package com.example.demo.services.implementServices;

import com.example.demo.models.ClientLoan;
import com.example.demo.services.ClientLoanService;
import com.example.demo.repositories.ClientLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientLoanServiceImpl implements ClientLoanService {

    @Autowired
    ClientLoanRepository clientLoanRepository;

    public ClientLoan saveClientLoan(ClientLoan clientLoan){
        return clientLoanRepository.save(clientLoan);
    }
}