package com.coffee.system.config.security.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.config.security.dto.RegisterDTO;
import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.model.User;
import com.coffee.system.config.security.model.UserLogin;
import com.coffee.system.config.security.model.RequestLogin;
import com.coffee.system.config.security.service.UserRoleService;
import com.coffee.system.service.UserService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses= {UserRoleService.class, UserService.class})
public interface UserLoginMapper {
	UserLoginMapper INSTANCE = Mappers.getMapper(UserLoginMapper.class);
	
	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "role" , source = "roleId")
//	@Mapping(target = "user" , source = "userId")
	RequestLogin toUserRequestLogin(UserLoginDto userLoginDto);
	
	User registerDtoTOUser(RegisterDTO model);
	
}