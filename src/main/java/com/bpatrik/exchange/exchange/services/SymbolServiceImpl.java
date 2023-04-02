package com.bpatrik.exchange.exchange.services;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.exceptions.ResourceNotFoundException;
import com.bpatrik.exchange.exchange.models.Symbol;
import com.bpatrik.exchange.exchange.repositories.SymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SymbolServiceImpl implements SymbolService {

    @Autowired
    SymbolRepository symbolRepository;

    @Override
    public List<Symbol> fetchAllSymbols() throws ResourceNotFoundException {
        return symbolRepository.getAll();
    }

    @Override
    public Integer create(Integer symbol_id, String name) throws BadRequestException {
        return symbolRepository.Create(symbol_id, name);
    }
}
