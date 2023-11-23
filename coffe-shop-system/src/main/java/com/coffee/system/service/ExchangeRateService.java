package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.ExchangeRateDto;
import com.coffee.system.model.entity.ExchangeRate;

public interface ExchangeRateService {

    ExchangeRate getExchangeRateById(int id);
    
    List<ExchangeRate> getExchangeRateList();
    
    ExchangeRate insertExchangeRate(ExchangeRateDto exchangeRateDto);
    
    ExchangeRate updateExchangeRate(int id, ExchangeRateDto exchangeRateDto);
    
    String deleteExchangeRate(int id);
}
