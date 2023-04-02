package com.bpatrik.exchange.exchange.repositories;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.exceptions.ResourceNotFoundException;
import com.bpatrik.exchange.exchange.models.Convert;

import java.util.List;

public interface ConvertRepository {

    Integer Create(Integer convert_id, String from, String to, Integer rate) throws BadRequestException;

    Integer getRateByFromAndTo(String from, String to) throws ResourceNotFoundException;
}
