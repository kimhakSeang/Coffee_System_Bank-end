package com.coffee.system.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.PreOrderDto;
import com.coffee.system.model.entity.Customer;
import com.coffee.system.model.entity.Item;
import com.coffee.system.model.entity.PreOrder;
import com.coffee.system.service.CustomerService;
import com.coffee.system.service.ItemService;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = { CustomerService.class, ItemService.class} )
public interface PreOrderMapper {
	
	PreOrderMapper INSTANCE = Mappers.getMapper(PreOrderMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "customers", source = "customersId")
	@Mapping(target = "items", source = "itemsId")
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	PreOrder toPreOrder(PreOrderDto PreOrderDto);
	
	@Mapping(target = "customersId", source = "customers", qualifiedByName =  "toCustomersId")
	@Mapping(target = "itemsId", source = "items", qualifiedByName =  "toItemsId")
	PreOrderDto toPreOrderDto(PreOrder PreOrder);
	
	@Named("toCustomersId")
	default List<Integer> toCustomerId(List<Customer> listCustomer) {
		 return listCustomer.stream().map(a->a.getId()).toList();
	}
	@Named("toItemsId")
	default List<Integer> toItemId(List<Item> listItem) {
		return listItem.stream().map(a->a.getId()).toList();
	}
}
