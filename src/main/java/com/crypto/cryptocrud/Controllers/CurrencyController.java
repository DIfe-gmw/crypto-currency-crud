package com.crypto.cryptocrud.Controllers;

import java.util.List;
import java.util.Map;

import com.crypto.cryptocrud.Models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crypto.cryptocrud.Services.CurrencyService;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency")
    public List<Currency> controller_getAllCurrency() {
        return currencyService.getAllCurrency();
    }

    @GetMapping("/currency/{id}")
    public ResponseEntity<Currency> controller_getCurrencyById(@PathVariable Long id) {
    	return currencyService.getCurrencyById(id);
    }
    
    @PostMapping("/currency")
    public void controller_registerNewCurrency(@RequestBody Currency currency) {
        currencyService.registerNewCurrency(currency);
    }
    
    @PutMapping("/currency/{id}")
    public ResponseEntity<Currency> controller_updateCurrency(@PathVariable Long id, @RequestBody Currency currencyDetails) {
    	return currencyService.updateCurrency(id, currencyDetails);
    }
    
    @DeleteMapping("/currency/{id}")
    public ResponseEntity<Map<String,Boolean>> controller_deleteCurrency(@PathVariable Long id) {
    	return currencyService.deleteCurrency(id);
    }
}
