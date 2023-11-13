package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.coffee.system.model.ExchangeRate;
import com.coffee.system.model.dto.ExchangeRateDto;
import com.coffee.system.service.PaymentService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PaymentService.class)
public interface ExchangeRateMapper {
	@Mapping(target = "id", ignore = true)
	ExchangeRate toExchangeRate(ExchangeRateDto exchangeRateDto);
	
	ExchangeRateDto toExchangeRateDto(ExchangeRate exchangeRate);
	
}