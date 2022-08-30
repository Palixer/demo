package com.example.demo.services.implementServices;

import com.example.demo.models.Card;
import com.example.demo.repositories.CardRepository;
import com.example.demo.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public Card findCardByNumber(String number){
        return cardRepository.findByNumber(number);
    }

    @Override
    public Card saveCard(Card card){
        return cardRepository.save(card);
    }

    @Override
    public Card findById(long id){
        return cardRepository.findById(id).orElse(null);
    }
}
