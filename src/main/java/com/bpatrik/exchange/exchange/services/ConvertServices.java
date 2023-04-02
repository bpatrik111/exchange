package com.bpatrik.exchange.exchange.services;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface ConvertServices {
    ResponseEntity<Integer> getRate(String from, String to) throws ResourceNotFoundException;

    ResponseEntity<Integer> addConvert(String from, String to, Integer rate) throws BadRequestException;
}
