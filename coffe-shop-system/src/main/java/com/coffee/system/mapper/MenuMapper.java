package com.coffee.system.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.coffee.system.model.Item;
import com.coffee.system.model.Menu;
import com.coffee.system.model.dto.MenuDto;
import com.coffee.system.service.CategoryService;
import com.coffee.system.service.ItemService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { CategoryService.class, ItemService.class})
public interface MenuMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "items", source = "itemId")
	Menu toMenu(MenuDto MenuDto);
	
	@Mapping(target = "itemId", expression = "java(toListItem(menu.getItems()))")
	MenuDto toMenuDto(Menu menu);

	default List<Integer> toListItem(List<Item> items ){
		return items.stream().map(i->i.getId()).toList();
	}
}
