package com.coffee.system.config.security.service;


import java.util.List;

import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.model.UserRequestLogin;

public interface UserLoginService {
	
	UserRequestLogin register( UserLoginDto userLoginDto);
	
	void update(int id, UserLoginDto userLoginDto);
	
	void delete(int id);
	
	UserRequestLogin getUserRequestLogin(int id);
	
	List<UserRequestLogin> getListUserLogin();
}
