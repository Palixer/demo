package com.example.demo.repositories;

import com.example.demo.models.ClientLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ClientLoanRepository extends JpaRepository<ClientLoan, Long> {

}
