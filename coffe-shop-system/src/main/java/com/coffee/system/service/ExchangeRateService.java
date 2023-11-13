package com.coffee.system.service;

import com.coffee.system.model.ExchangeRate;

public interface ExchangeRateService {

    ExchangeRate getExchangeRateById(int id);
    
    ExchangeRate insertExchangeRate(ExchangeRate exchangeRate);
    
    ExchangeRate updateExchangeRate(ExchangeRate exchangeRate);
    
    String deleteExchangeRate(int id);
}
