package com.coffee.system.config.security.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.coffee.system.config.security.dto.EmailTokenDto;
import com.coffee.system.config.security.model.EmailToken;
import com.coffee.system.config.security.service.UserLoginService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserLoginService.class})
public interface EmailMapper {
	EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "userLogin", source = "userId")
	EmailToken  toEmailToken(EmailTokenDto emailTokenDto);
}
