package com.coffee.system.config.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.coffee.system.config.security.dto.UserPermissionDto;
import com.coffee.system.config.security.model.UserPermission;

@Mapper
public interface UserPermissionMapper {
	UserPermissionMapper  INSTANCE = Mappers.getMapper(UserPermissionMapper.class);
	
	@Mapping(target = "id", ignore = true)
	UserPermission toUserPermission(UserPermissionDto userPermissionDto);
	
	UserPermissionDto toUserPermissionDto(UserPermission userPermission);
}
