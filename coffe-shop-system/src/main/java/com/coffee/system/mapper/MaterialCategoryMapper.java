package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.MaterialCategoryDto;
import com.coffee.system.model.entity.MaterialCategory;
import com.coffee.system.service.MaterialCategoryService;

@Mapper(componentModel =MappingConstants.ComponentModel.SPRING, uses = MaterialCategoryService.class)
public interface MaterialCategoryMapper {
	MaterialCategoryMapper INSTANCE = Mappers.getMapper(MaterialCategoryMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	MaterialCategory toMaterialCategory(MaterialCategoryDto materialCategoryDto);
	
	MaterialCategoryDto toMaterialCategoryDto(MaterialCategory materialCategory);
}
