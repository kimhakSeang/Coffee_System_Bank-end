package com.coffee.system.service;

import java.util.List;

import com.coffee.system.config.security.model.User;
import com.coffee.system.model.dto.UserDto;

public interface UserService {
	
       User getUserById(int id);

       List<User> getUserList();
       
       User insertUser(UserDto User);
       
       User updateUser(int id, UserDto User);
       
       String deleteUser(int id);
}
