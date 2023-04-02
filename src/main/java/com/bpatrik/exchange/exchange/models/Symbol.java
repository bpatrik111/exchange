package com.bpatrik.exchange.exchange.models;

public class Symbol {

    private Integer symbol_id;
    private String name;

    public Integer getSymbol_id() {
        return symbol_id;
    }

    public void setSymbol_id(Integer symbol_id) {
        this.symbol_id = symbol_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol(Integer symbol_id, String name) {
        this.symbol_id = symbol_id;
        this.name = name;
    }
}
