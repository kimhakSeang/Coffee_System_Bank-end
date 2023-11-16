package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.CustomerDto;
import com.coffee.system.model.system.Customer;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(target = "id", ignore = true)
	Customer toCustomer(CustomerDto CustomerDto);
	CustomerDto toCustomerDto(Customer Customer);
}
