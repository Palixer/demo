package com.example.demo.repositories;


import com.example.demo.models.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoinRepository extends JpaRepository<Coin, Long> {
    Coin findByTicker(String ticker);
}
