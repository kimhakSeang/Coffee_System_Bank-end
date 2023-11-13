package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.coffee.system.model.Discount;
import com.coffee.system.model.dto.DiscountDto;
import com.coffee.system.service.PaymentService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PaymentService.class)
public interface DiscountMapper {
	
	@Mapping(target = "id", ignore = true)
	Discount toDiscount(DiscountDto DiscountDto);
	
	DiscountDto toDiscountDto(Discount discount);
}
