package com.coffee.system.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.model.ExchangeRate;
import com.coffee.system.repository.ExchangeRateRepository;
import com.coffee.system.service.ExchangeRateService;
import com.coffee.system.util.ErrorUtil;
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{
	@Autowired
    private ExchangeRateRepository exchangeRateRepository;
    
	@Override
	public ExchangeRate getExchangeRateById(int id){
		Optional<ExchangeRate> exchangeRate= exchangeRateRepository.findById(id);
		if(exchangeRate.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"ExchangeRate's id("+id+") not found!");
		}
		return exchangeRate.get();
	}

	@Override
	public ExchangeRate insertExchangeRate(ExchangeRate exchangeRate) {
		return exchangeRateRepository.save(exchangeRate);
	}

	@Override
	public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate) {
		getExchangeRateById(exchangeRate.getId());
		return exchangeRateRepository.save(exchangeRate);
	}

	@Override
	public String deleteExchangeRate(int id) {
		getExchangeRateById(id);
		exchangeRateRepository.deleteById(id);
		return "Delete Success.";
	}

}
