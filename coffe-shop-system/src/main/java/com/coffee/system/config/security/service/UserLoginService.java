package com.coffee.system.config.security.service;


import java.util.List;

import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.model.RequestLogin;

public interface UserLoginService {
	
	RequestLogin register( UserLoginDto userLoginDto);
	
	void update(int id, UserLoginDto userLoginDto);
	
	void delete(int id);
	
	RequestLogin getUserRequestLogin(int id);
	
	List<RequestLogin> getListUserLogin();
}
