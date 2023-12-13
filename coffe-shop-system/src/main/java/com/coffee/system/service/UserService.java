package com.coffee.system.service;

import java.util.List;
import java.util.Optional;

import com.coffee.system.config.security.model.User;
import com.coffee.system.model.dto.UserDto;

public interface UserService {
	
       User getUserById(int id);
       
       Optional<User> getUserByEmail(String email);

       List<User> getUserList();
       
       User insertUser(UserDto User);
       
       User updateUser(int id, UserDto User);
       
       String deleteUser(int id);
}
