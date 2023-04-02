package com.bpatrik.exchange.exchange.services;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public class ConvertServicesImpl implements ConvertServices{
    @Override
    public ResponseEntity<Integer> getRate(String from, String to) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Integer> addConvert(String from, String to, Integer rate) throws BadRequestException {
        return null;
    }
}
