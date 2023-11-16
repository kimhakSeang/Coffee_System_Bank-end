package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.CategoryDto;
import com.coffee.system.model.system.Category;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	@Mapping(target = "id", ignore = true)
	Category toCategory(CategoryDto categoryDto);
	
	CategoryDto toCategoryDto(Category category);
}
