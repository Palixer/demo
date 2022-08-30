package com.example.demo.services;

import com.example.demo.models.Card;

public interface CardService {
    public Card findCardByNumber(String number);
    public Card saveCard(Card card);
    public Card findById(long id);
}