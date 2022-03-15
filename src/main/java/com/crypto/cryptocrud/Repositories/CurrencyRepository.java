package com.crypto.cryptocrud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crypto.cryptocrud.Models.Currency;
import java.util.Optional;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findCurrencyByName(String name);
}