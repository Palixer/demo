package com.example.demo.controllers;

import com.example.demo.dtos.CoinDTO;
import com.example.demo.models.Coin;
import com.example.demo.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoinController {

    @Autowired
    private CoinRepository coinRepository;

    @PostMapping("/convert")
    public ResponseEntity<Object> convertir(@RequestBody CoinDTO coinDTO) {

       Coin coinFrom = coinRepository.findByTicker(coinDTO.getTickerFrom());
       Coin coinTo = coinRepository.findByTicker(coinDTO.getTickerTo());

       if(coinFrom.getTicker().equals("USD") && coinTo.getTicker().equals("USD") || coinFrom.getTicker().equals("USD") && coinTo.getTicker().equals("EUR") ){
          return new ResponseEntity<>(coinDTO.getAmountToConvert()*1, HttpStatus.ACCEPTED);
       }





        return new ResponseEntity<>(coinFrom, HttpStatus.ACCEPTED);
    }




    //Crear lista con objeto que contiene el Repository.
    //Crear método que va a recibir el ticker de la moneda y que recorra la lista de Repository y nos traiga el factor de conversión de la moneda.

    //Crear un método "desdeDolar" para convertir de USD a cualquier moneda (USD monto * ARS factor de conversión).
    //Crear método "aDolar" para pasar de una moneda a USD (ARS monto/ARS factor de conversión).
    //Crear otro método para convertir otra moneda a cualquier moneda (Recibe ARS monto, aDolar(), desdeDolar() ).


}





