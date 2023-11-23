package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.ItemDto;
import com.coffee.system.model.entity.Item;
import com.coffee.system.service.CategoryService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CategoryService.class)
public interface ItemMapper {
	ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "category", source = "categoryId")
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	Item toItem(ItemDto ItemDto);
	
	@Mapping(target = "categoryId", expression = "java(item.getCategory().getId())" )
	public ItemDto mapItemToItemDto(Item item);

}
