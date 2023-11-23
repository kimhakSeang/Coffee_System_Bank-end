package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.config.security.model.Role;
import com.coffee.system.config.security.service.UserPermissionService;
import com.coffee.system.model.dto.RoleDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses= {UserPermissionService.class})
public interface RoleMapper {
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	@Mapping(target = "permission", source = "permissionId")
	Role toRole(RoleDto roleDto);
	
	@Mapping(target = "role", expression = "java(role.getRole())")
	@Mapping(target = "permissionId", expression = "java(role.getPermission().stream().map(r->r.getId()).toList())")
	RoleDto toRoleDto(Role role);
}
