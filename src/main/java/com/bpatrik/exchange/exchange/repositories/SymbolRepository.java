package com.bpatrik.exchange.exchange.repositories;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.exceptions.ResourceNotFoundException;
import com.bpatrik.exchange.exchange.models.Symbol;

import java.util.List;

public interface SymbolRepository {

    Integer Create(Integer symbol_id, String name) throws BadRequestException;

    List<Symbol> getAll() throws ResourceNotFoundException;



}
