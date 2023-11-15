package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.Payment;
import com.coffee.system.model.dto.PaymentDto;
import com.coffee.system.service.DiscountService;
import com.coffee.system.service.ExchangeRateService;
import com.coffee.system.service.PreOrderService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PreOrderService.class, ExchangeRateService.class, DiscountService.class})
public interface PaymentMapper {
	
	PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "orders", source = "listOrderId")
	@Mapping(target = "exchangeRate", source = "exchangeRatId")
	@Mapping(target = "discount", source = "discountId")
	Payment toPayment(PaymentDto paymentDto);
	
	@Mapping(target = "listOrderId", expression = "java(payment.getOrders().stream().map( p -> p.getId()).toList())")
	@Mapping(target = "discountId", expression = "java(payment.getDiscount().getId())")
	@Mapping(target = "exchangeRatId", expression = "java(payment.getExchangeRate().getId())")
	PaymentDto toPaymentDto(Payment payment);
}