package com.example.demo.dtos;

public class CoinDTO {

    private String tickerFrom;
    private String tickerTo;
    private double amountToConvert;


    public CoinDTO() {
    }


    public CoinDTO(String tickerFrom, String tickerTo, double amountToConvert) {
        this.tickerFrom = tickerFrom;
        this.tickerTo = tickerTo;
        this.amountToConvert = amountToConvert;
    }



    public String getTickerFrom() {
        return tickerFrom;
    }

    public void setTickerFrom(String tickerFrom) {
        this.tickerFrom = tickerFrom;
    }

    public String getTickerTo() {
        return tickerTo;
    }

    public void setTickerTo(String tickerTo) {
        this.tickerTo = tickerTo;
    }

    public double getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountToConvert(double amountToConvert) {
        this.amountToConvert = amountToConvert;
    }
}
