package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.UserDto;
import com.coffee.system.model.user.User;

public interface UserService {
	
       User getUserById(int id);

       List<User> getUserList();
       
       User insertUser(UserDto User);
       
       User updateUser(int id, UserDto User);
       
       String deleteUser(int id);
}
