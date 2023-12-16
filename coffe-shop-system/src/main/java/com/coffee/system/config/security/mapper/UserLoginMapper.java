package com.coffee.system.config.security.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.config.security.dto.RegisterDTO;
import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.model.RequestLogin;
import com.coffee.system.config.security.model.User;
import com.coffee.system.config.security.service.UserRoleService;
import com.coffee.system.config.security.service.UserService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses= {UserRoleService.class, UserService.class})
public interface UserLoginMapper {
	UserLoginMapper INSTANCE = Mappers.getMapper(UserLoginMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "accountNonExpired", ignore = true)
	@Mapping(target = "accountNonLocked", ignore = true)
	@Mapping(target = "credentialsNonExpired", ignore = true)
	@Mapping(target = "enabled", ignore = true)
	@Mapping(target = "loginDate", ignore = true)
	@Mapping(target = "logoutYN", ignore = true)
//	@Mapping(target = "token", ignore = true)
	@Mapping(target = "user", ignore = true)
	RequestLogin toUserRequestLogin(UserLoginDto userLoginDto);
	
	User registerDtoTOUser(RegisterDTO model);
	
}

//accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, loginDate, logoutYN, token, user