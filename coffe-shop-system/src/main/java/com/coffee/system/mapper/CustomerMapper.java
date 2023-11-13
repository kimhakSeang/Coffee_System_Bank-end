package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.coffee.system.model.Customer;
import com.coffee.system.model.dto.CustomerDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
	@Mapping(target = "id", ignore = true)
	Customer toCustomer(CustomerDto CustomerDto);
	CustomerDto toCustomerDto(Customer Customer);
}
