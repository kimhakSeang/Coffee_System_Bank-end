package com.coffee.system.config.security.service;

import com.coffee.system.config.security.dto.RegisterDTO;
import com.coffee.system.config.security.model.RequestLogin;

public interface AuthService {
	RequestLogin register(RegisterDTO registerDTO);
}
