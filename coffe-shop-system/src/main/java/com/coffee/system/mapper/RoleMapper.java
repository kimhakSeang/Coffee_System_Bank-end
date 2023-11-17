package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.RoleDto;
import com.coffee.system.model.user.Role;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	@Mapping(target = "id", ignore = true)
	Role toRole(RoleDto roleDto);
	
	RoleDto toRoleDto(Role role);
}
