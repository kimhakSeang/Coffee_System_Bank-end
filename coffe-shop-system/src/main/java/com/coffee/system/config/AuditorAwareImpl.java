package com.coffee.system.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;


public class AuditorAwareImpl implements  AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		if(email.isBlank()|| email.equals("anonymousUser")) {
			return Optional.of("User_Signup");
		}
		return Optional.of(email);
	}

}
