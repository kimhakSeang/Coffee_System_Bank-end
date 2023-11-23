package com.coffee.system.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.MenuDto;
import com.coffee.system.model.entity.Item;
import com.coffee.system.model.entity.Menu;
import com.coffee.system.service.CategoryService;
import com.coffee.system.service.ItemService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { CategoryService.class, ItemService.class})
public interface MenuMapper {
	
	MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "items", source = "itemId")
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	Menu toMenu(MenuDto MenuDto);
	
	@Mapping(target = "itemId", expression = "java(toListItem(menu.getItems()))")
	MenuDto toMenuDto(Menu menu);

	default List<Integer> toListItem(List<Item> items ){
		return items.stream().map(i->i.getId()).toList();
	}
}
