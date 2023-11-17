package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.UserMapper;
import com.coffee.system.model.dto.UserDto;
import com.coffee.system.model.user.User;
import com.coffee.system.repository.UserRepository;
import com.coffee.system.service.UserService;
import com.coffee.system.util.ErrorUtil;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;
    
	@Override
	public User getUserById(int id){
		Optional<User> User= userRepository.findById(id);
		if(User.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"User's id("+id+") not found!");
		}
		return User.get();
	}
	
	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public User insertUser(UserDto UserDto) {
		User User = UserMapper.INSTANCE.toUser(UserDto);
		userRepository.save(User);
		return User;
	}

	@Override
	public User updateUser(int id, UserDto UserDto) {
		getUserById(id);
		User User = UserMapper.INSTANCE.toUser(UserDto);
		User.setId(id);
		return userRepository.save(User);
	}
	@Override
	public String deleteUser(int id) {
		getUserById(id);
		userRepository.deleteById(id);
		return "Delete Success.";
	}
}
