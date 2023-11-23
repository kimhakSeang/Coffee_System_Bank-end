package com.coffee.system.config.security.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.config.security.model.UserLoginDetail;
import com.coffee.system.config.security.model.UserRequestLogin;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserRequestLoginMapper {
	UserRequestLoginMapper INSTANCE = Mappers.getMapper(UserRequestLoginMapper.class);
	
//	@Mapping(target = "authorities" , ignore = true/*source = "role" , qualifiedByName = "role"*/)
	 @Mapping(target = "username", source = "email")
	 UserLoginDetail toUserLoginDetail(UserRequestLogin userRequestLogin);
	 
//	 @Named("role")
//	 default Set<SimpleGrantedAuthority> getAuthorization(Role userRole) {
//		 Set<SimpleGrantedAuthority> grantedAuthorities = userRole.getPermission ()
//														 .stream()
//														 .map(a-> new SimpleGrantedAuthority(userRole.getRole().getName()+"_"+a.getPermission()))
//														 .collect(Collectors.toSet());
//		 
//		 return grantedAuthorities;
//	 }
}
