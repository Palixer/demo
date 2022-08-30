package com.example.demo.controllers;

import com.example.demo.dtos.CardDTO;
import com.example.demo.models.Card;
import com.example.demo.models.CardColor;
import com.example.demo.models.CardType;
import com.example.demo.models.Client;
import com.mindhub.homebanking.models.*;
import com.example.demo.repositories.CardRepository;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    public CardRepository repo;

    @RequestMapping("/cards")
    public List<CardDTO> getAll() {
        return repo.findAll().stream().map(CardDTO::new).collect(toList());
    }

    @RequestMapping("/cards/{id}")
    public CardDTO getAccount(@PathVariable Long id) {
        return repo.findById(id).map(CardDTO::new).orElse(null);
    }


    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    public CardRepository cardRepository;


    @PostMapping("/clients/current/cards")
    public ResponseEntity<Object> registerCard(Authentication authentication, @RequestParam CardType cardType, @RequestParam CardColor cardColor) {

        Client clientConnect = clientRepository.findByEmail(authentication.getName());

        AtomicInteger count = new AtomicInteger();

        if (clientConnect != null) {

            Stream<Card> stream = clientConnect.getCards().stream();
            stream.forEach(card -> {
                if (card.getType() == cardType) count.getAndIncrement();
            });

            if (count.get() > 2) {
                return new ResponseEntity<>("You already have 3 cards of this type!", HttpStatus.FORBIDDEN);
            } else {

                String randomStr = "";
                for (int i = 0; i < 4; i++) {
                    if (i == 3) {
                        randomStr += getRandomNumber(1001, 10000);
                    } else {
                        randomStr += getRandomNumber(1001, 10000) + "-";
                    }
                }

                Card card = new Card(clientConnect.getFirstName() + " " + clientConnect.getLastName(), cardType, cardColor, randomStr, getRandomNumberCvv(101, 1000), LocalDate.now(), LocalDate.now().plusYears(5));

                clientConnect.addCard(card);
                cardRepository.save(card);

                return new ResponseEntity<>("Succesfuly", HttpStatus.CREATED);

            }
        }else{
            return new ResponseEntity<>("Usuario no autenticado!", HttpStatus.FORBIDDEN);
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int getRandomNumberCvv(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}