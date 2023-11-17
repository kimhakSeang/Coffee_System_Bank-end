package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.ImportDto;
import com.coffee.system.model.system.Import;
import com.coffee.system.service.MaterialService;
import com.coffee.system.service.UserService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {MaterialService.class, UserService.class})
public interface ImportMapper {
	ImportMapper INSTANCE = Mappers.getMapper(ImportMapper.class);
	
	@Mapping( target = "id", ignore = true)
	@Mapping(target = "materials", source = "materialsId")
	@Mapping(target = "user", source = "userId")
	Import toImport(ImportDto importDto);
	
	ImportDto toImportDto(ImportDto importDto);
}