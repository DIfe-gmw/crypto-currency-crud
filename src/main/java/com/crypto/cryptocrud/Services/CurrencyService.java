package com.crypto.cryptocrud.Services;

import java.util.List;
import com.crypto.cryptocrud.Models.Currency;
import com.crypto.cryptocrud.Repositories.CurrencyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
    
    public List<Currency> getAllCurrency() {
        return currencyRepository.findAll();
    }

    public void registerNewCurrency(Currency currency) {
        currencyRepository.save(currency);
    }
}
