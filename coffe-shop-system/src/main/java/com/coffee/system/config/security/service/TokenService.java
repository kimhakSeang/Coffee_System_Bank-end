package com.coffee.system.config.security.service;


import java.util.List;
import java.util.Optional;

import com.coffee.system.config.security.dto.TokenDto;
import com.coffee.system.config.security.model.Token;


public interface TokenService {
	
	String signUp(TokenDto emailTokenDto);
	
	void confirm(String token);

	void sender(Token emailToken, String subject);

	Token findEmailByToken(String token);
	
	List<Token> getAll(); 
	
	boolean isVerify(String email);
	
	Optional<Token> getEmailTokenByEmail(String email);
}
