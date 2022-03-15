package com.crypto.cryptocrud.Services;

import java.util.List;
import com.crypto.cryptocrud.Models.Currency;
import com.crypto.cryptocrud.Repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crypto.cryptocrud.Exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

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

    public ResponseEntity<Currency> getCurrencyById(Long id) {
    	Currency currency = currencyRepository.findById(id)
    	.orElseThrow(() -> 
    		new ResourceNotFoundException("Currency does not exist with id:" + id)
    	);
    	return ResponseEntity.ok(currency);
    }
    
    public void registerNewCurrency(Currency currency) {
        currencyRepository.save(currency);
    }
    
    public ResponseEntity<Currency> updateCurrency(Long id, Currency currencyDetails) {
    	Currency currency = currencyRepository.findById(id)
    	.orElseThrow(() -> 
        	new ResourceNotFoundException("Currency does not exist with id:" + id)
        );
    	
    	currency.setName(currencyDetails.getName());
    	currency.setDescription(currencyDetails.getDescription());
    	currency.setValue(currencyDetails.getValue());
    	currency.setActive(currencyDetails.isActive());
    	
    	Currency updatedCurrency = currencyRepository.save(currency);
    	
    	return ResponseEntity.ok(updatedCurrency);
    }
}
