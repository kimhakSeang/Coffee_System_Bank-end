package com.coffee.system.config.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coffee.system.config.security.dto.TokenDto;
import com.coffee.system.config.security.mapper.UserMapper;
import com.coffee.system.config.security.model.Token;
import com.coffee.system.config.security.model.User;
import com.coffee.system.config.security.repository.UserRepository;
import com.coffee.system.config.security.service.TokenService;
import com.coffee.system.config.security.service.UserService;
import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.model.dto.UserDto;
import com.coffee.system.util.ErrorUtil;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder encoder;
    
	@Override
	public User getUserById(int id){
		Optional<User> User= userRepository.findById(id);
		if(User.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"User's id("+id+") not found!");
		}
		return User.get();
	}
	
	@Override
	public Optional<User> getUserByEmail(String email){
		return  userRepository.findUserByEmail(email);
//		if(user.isEmpty()) {
//			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"User's email("+email+") not found!");
//		}
//		return User.get();
	}
	
	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public User insertUser(UserDto userDto) {
		userDto.setPassword(encoder.encode(userDto.getPassword()));
		Optional<User> userByEmail = userRepository.findUserByEmail(userDto.getEmail());
		
		//Check Email
		if(userByEmail.isPresent()) {
			throw new RuntimeExceptionImpl(ErrorUtil.READY_EXIST, "Email is ready exist!!");
		}
		
		//Register User
		User user = userMapper.toUser(userDto);
		userRepository.save(user);
		
		return user;
	}

	@Override
	public User updateUser(int id, UserDto UserDto) {
		getUserById(id);
		User User = userMapper.toUser(UserDto);
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
