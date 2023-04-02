package com.bpatrik.exchange.exchange.services;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.exceptions.ResourceNotFoundException;
import com.bpatrik.exchange.exchange.models.Symbol;

import java.util.List;

public interface SymbolService{

    List<Symbol> fetchAllSymbols() throws ResourceNotFoundException;

    Integer create(Integer symbol_id, String name) throws BadRequestException;

}
