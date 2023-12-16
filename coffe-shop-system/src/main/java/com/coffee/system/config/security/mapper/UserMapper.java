package com.coffee.system.config.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.coffee.system.config.security.model.User;
import com.coffee.system.config.security.service.RoleService;
import com.coffee.system.model.dto.UserDto;

@Mapper(componentModel = "spring" , uses = {RoleService.class} )
public interface UserMapper {
	
//	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "role", source = "roleId")
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	User toUser(UserDto UserDto);
	
	@Mapping(target = "roleId", expression = "java(user.getRole().getId())")
	UserDto toUserDto(User user);
}