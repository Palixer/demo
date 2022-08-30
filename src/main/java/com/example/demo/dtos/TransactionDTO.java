package com.example.demo.dtos;

import com.example.demo.models.Transaction;
import com.example.demo.models.TransactionType;

import java.util.Date;

public class TransactionDTO {
    private Long id;
    private TransactionType type;
    private double amount;
    private String description;
    private Date creationDate;



    public TransactionDTO(Transaction transaction) {
        this.id= transaction.getId();
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.description = transaction.getDescription();
        this.creationDate=transaction.getCreationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

