package com.coffee.system.config.security.service;


import java.util.List;

import com.coffee.system.config.security.dto.EmailTokenDto;
import com.coffee.system.config.security.model.EmailToken;


public interface EmailService {
	
	String signUp(EmailTokenDto emailTokenDto);
	
	void confirm(String token);

	void sender(EmailToken emailToken, String subject);

	EmailToken findEmailByToken(String token);
	
	List<EmailToken> getAll(); 
	
	boolean isVerify(String email);
}
