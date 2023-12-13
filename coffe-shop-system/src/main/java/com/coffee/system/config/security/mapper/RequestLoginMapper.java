package com.coffee.system.config.security.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.coffee.system.config.security.model.RequestLogin;
import com.coffee.system.config.security.model.UserLoginDetail;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RequestLoginMapper {
	RequestLoginMapper INSTANCE = Mappers.getMapper(RequestLoginMapper.class);

	@Mapping(target = "authorities" , source = "userRequestLogin" , qualifiedByName = "role")
	@Mapping(target = "username", expression = "java(userRequestLogin.getUser().getEmail())")
	@Mapping(target = "password", expression = "java(userRequestLogin.getUser().getPassword())")
	UserLoginDetail toUserLoginDetail(RequestLogin userRequestLogin);

	@Named("role")
	default Set<SimpleGrantedAuthority> getAuthorization(RequestLogin userRequestLogin) {
		Set<SimpleGrantedAuthority> grantedAuthorities = userRequestLogin
																		.getUser()
																		.getRole()
																		.getPermission()
																		.stream()
				.map(a -> new SimpleGrantedAuthority(userRequestLogin
																		.getUser()
																		.getRole()
																		.getRole() 
																		+ "_" + 
																		a.getPermission()))
				.collect(Collectors.toSet());

		return grantedAuthorities;
	}
}
