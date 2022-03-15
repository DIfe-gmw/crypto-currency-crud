package com.crypto.cryptocrud.Controllers;

import java.util.List;
import com.crypto.cryptocrud.Models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crypto.cryptocrud.Services.CurrencyService;

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

    @PostMapping("/currency")
    public void controller_registerNewCurrency(@RequestBody Currency currency) {
        currencyService.registerNewCurrency(currency);
    }
}
