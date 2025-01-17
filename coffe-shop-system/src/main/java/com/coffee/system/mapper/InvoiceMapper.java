package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.InvoiceDto;
import com.coffee.system.model.entity.Invoice;
import com.coffee.system.service.PaymentService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PaymentService.class)
public interface InvoiceMapper {
	
	InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "payment", source = "paymentId")
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	Invoice toInvoice(InvoiceDto invoiceDto);
	
	@Mapping(target = "paymentId", expression="java(invoice.getPayment().getId())")
	InvoiceDto toInvoiceDto(Invoice invoice);
	
}
