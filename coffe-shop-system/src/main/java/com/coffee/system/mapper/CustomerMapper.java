package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.CustomerDto;
import com.coffee.system.model.entity.Customer;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	Customer toCustomer(CustomerDto CustomerDto);
	
	CustomerDto toCustomerDto(Customer Customer);
}
