package com.bpatrik.exchange.exchange.endpoints;

import com.bpatrik.exchange.exchange.models.Symbol;
import com.bpatrik.exchange.exchange.services.SymbolService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/symbols")
public class SymbolEndpoint {

    @Autowired
    SymbolService symbolService;

    @GetMapping("")
    public ResponseEntity<List<Symbol>> getAllSymbol(HttpServletRequest request) {
        int symbol_id = (Integer) request.getAttribute("SYMBOL_ID");
        List<Symbol> symbols = symbolService.fetchAllSymbols();
        return new ResponseEntity<>(symbols, HttpStatus.OK);
    }
}
