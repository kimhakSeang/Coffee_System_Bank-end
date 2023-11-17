package com.coffee.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.model.dto.UserDto;
import com.coffee.system.model.user.User;
import com.coffee.system.service.RoleService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoleService.class})
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "role", source = "roleId")
	User toUser(UserDto UserDto);
	
	@Mapping(target = "roleId", expression = "java(user.getRole().getId())")
	UserDto toUserDto(User user);
}