package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.coffee.system.model.Item;
import com.coffee.system.model.dto.ItemDto;
import com.coffee.system.service.CategoryService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CategoryService.class)
public interface ItemMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "category", source = "categoryId")
	Item toItem(ItemDto ItemDto);
	
	@Mapping(target = "categoryId", expression = "java(item.getCategory().getId())" )
	public ItemDto mapItemToItemDto(Item item);

}
