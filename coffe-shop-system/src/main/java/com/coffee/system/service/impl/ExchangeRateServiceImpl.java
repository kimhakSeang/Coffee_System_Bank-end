package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.ExchangeRateMapper;
import com.coffee.system.model.dto.ExchangeRateDto;
import com.coffee.system.model.entity.ExchangeRate;
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
	public List<ExchangeRate> getExchangeRateList() {
		return exchangeRateRepository.findAll();
	}

	@Override
	public ExchangeRate insertExchangeRate(ExchangeRateDto exchangeRateDto) {
		ExchangeRate exchangeRate = ExchangeRateMapper.INSTANCE.toExchangeRate(exchangeRateDto);
		exchangeRateRepository.save(exchangeRate);
		return exchangeRate;
	}

	@Override
	public ExchangeRate updateExchangeRate(int id, ExchangeRateDto exchangeRateDto) {
		getExchangeRateById(id);
		ExchangeRate exchangeRate = ExchangeRateMapper.INSTANCE.toExchangeRate(exchangeRateDto);
		exchangeRate.setId(id);
		return exchangeRateRepository.save(exchangeRate);
	}
	
	@Override
	public String deleteExchangeRate(int id) {
		getExchangeRateById(id);
		exchangeRateRepository.deleteById(id);
		return "Delete Success.";
	}

}
