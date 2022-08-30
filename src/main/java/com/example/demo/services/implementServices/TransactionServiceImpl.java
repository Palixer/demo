package com.example.demo.services.implementServices;

import com.example.demo.services.TransactionService;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

}
