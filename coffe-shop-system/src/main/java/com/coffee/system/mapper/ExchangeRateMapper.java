package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.ExchangeRateDto;
import com.coffee.system.model.entity.ExchangeRate;
import com.coffee.system.service.PaymentService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PaymentService.class)
public interface ExchangeRateMapper {
	ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	ExchangeRate toExchangeRate(ExchangeRateDto exchangeRateDto);
	
	ExchangeRateDto toExchangeRateDto(ExchangeRate exchangeRate);
	
}
