package com.bpatrik.exchange.exchange.endpoints;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.models.Symbol;
import com.bpatrik.exchange.exchange.services.ConvertServices;
import com.bpatrik.exchange.exchange.services.SymbolService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class ConvertEndpoint {

    @Autowired
    ConvertServices convertServices;

    @GetMapping("/convert")
    public ResponseEntity<Integer> getRate(HttpServletRequest request, @RequestBody Map<String, Object> convertMap) {

        String from = (String) convertMap.get("from_");
        String to = (String) convertMap.get("to_");
        return convertServices.getRate(from, to);

    }

    @PostMapping("/change-rate")
    public ResponseEntity<Integer> addConvert(HttpServletRequest request, @RequestBody Map<String, Object> convertMap) throws BadRequestException {

        String from = (String) convertMap.get("from_");
        String to = (String) convertMap.get("to_");
        Integer rate = (Integer) convertMap.get("rate");
        return convertServices.addConvert(from, to, rate);

    }

}
