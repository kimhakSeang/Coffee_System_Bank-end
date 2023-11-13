package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.coffee.system.model.Category;
import com.coffee.system.model.dto.CategoryDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
	
	@Mapping(target = "id", ignore = true)
	Category toCategory(CategoryDto categoryDto);
	
	CategoryDto toCategoryDto(Category category);
}
