package com.example.demo.repositories;

import com.example.demo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
