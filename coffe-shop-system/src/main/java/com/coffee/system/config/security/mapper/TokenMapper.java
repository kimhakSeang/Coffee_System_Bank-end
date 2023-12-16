package com.coffee.system.config.security.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.config.security.dto.TokenDto;
import com.coffee.system.config.security.model.Token;
import com.coffee.system.config.security.service.UserService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserService.class})
public interface TokenMapper {
	TokenMapper INSTANCE = Mappers.getMapper(TokenMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "user", source= "userId")
	Token  toEmailToken(TokenDto emailTokenDto);
}
