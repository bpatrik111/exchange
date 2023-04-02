package com.bpatrik.exchange.exchange.repositories;

import com.bpatrik.exchange.exchange.models.Currency;

public interface CurrencyRepository {

    Integer Create(String symbol_from, String symbol_to, Integer rate);

    Currency

}
