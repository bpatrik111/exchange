package com.bpatrik.exchange.exchange.models;

public class Currency {

    private Integer currency_id;
    private String symbol_from;
    private String symbol_to;
    private Integer rate;

    public Currency(Integer currency_id, String symbol_from, String symbol_to, Integer rate){
        this.currency_id = currency_id;
        this.symbol_from = symbol_from;
        this.symbol_to = symbol_to;
        this.rate = rate;
    }

    public Integer getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(Integer currency_id) {
        this.currency_id = currency_id;
    }

    public String getSymbol_from() {
        return symbol_from;
    }

    public void setSymbol_from(String symbol_from) {
        this.symbol_from = symbol_from;
    }

    public String getSymbol_to() {
        return symbol_to;
    }

    public void setSymbol_to(String symbol_to) {
        this.symbol_to = symbol_to;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
