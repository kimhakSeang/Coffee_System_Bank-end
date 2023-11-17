package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.MaterialDto;
import com.coffee.system.model.system.Material;
import com.coffee.system.service.MaterialCategoryService;

@Mapper(componentModel =MappingConstants.ComponentModel.SPRING, uses = MaterialCategoryService.class)
public interface MaterialMapper {
	MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "materialCategory", source = "materialCategoryId")
	Material toMaterial(MaterialDto materialDto);
	
	@Mapping(target = "materialCategoryId", expression = "java(material.getMaterialCategory().getId())")
	MaterialDto toMaterialDto(Material material);
}
