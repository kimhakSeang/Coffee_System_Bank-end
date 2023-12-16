package com.coffee.system.config.security.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.mapper.UserLoginMapper;
import com.coffee.system.config.security.model.RequestLogin;
import com.coffee.system.config.security.model.User;
import com.coffee.system.config.security.model.UserLogin;
import com.coffee.system.config.security.repository.UserLoginRepository;
import com.coffee.system.config.security.service.UserLoginService;
import com.coffee.system.config.security.service.UserService;
import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.util.ErrorUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRequestLoginServiceImpl implements UserLoginService{
    private final UserLoginRepository userLoginRepository;
    private final UserLoginMapper userLoginMapper;
    private final UserService userService;
    
    
	@Override
	public RequestLogin register( UserLoginDto userLoginDto) {
		
		Optional<User> user = userService.getUserByEmail(userLoginDto.getEmail());
		if(user.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND, "Email not found!");
		}
		
		RequestLogin userRequestLogin = userLoginMapper.toUserRequestLogin(userLoginDto);
		userRequestLogin.setUser(user.get());
		return userLoginRepository.save(userRequestLogin);
	} 

	@Override
	public void update(int id, UserLoginDto userLoginDto) {
		Optional<RequestLogin> getUserLogin = userLoginRepository.findById(id);
		if(getUserLogin.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"User login is not exist!");
		}
		RequestLogin userRequestLogin = userLoginMapper.toUserRequestLogin(userLoginDto);
		userLoginRepository.save(userRequestLogin);
	}

	@Override
	public RequestLogin getUserRequestLogin(int id) {
		Optional<RequestLogin> getUserLogin = userLoginRepository.findById(id);
		if(getUserLogin.isEmpty()||!getUserLogin.get().isEnabled()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"User login is not exist or not yet enable!");
		}
		return getUserLogin.get();
	}

	@Override
	public List<RequestLogin> getListUserLogin() {
		return userLoginRepository.findAll();
	}

	@Override
	public void delete(int id) {
		Optional<RequestLogin> getUserLogin = userLoginRepository.findById(id);
		if(getUserLogin.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"User login is not exist!");
		}
		RequestLogin userRequestLogin = getUserLogin.get();
		userRequestLogin.setEnabled(false);
		userLoginRepository.save(userRequestLogin);
	}

	@Override
	public Optional<RequestLogin> getUserRequestLoginByUserId(int id) {
		return userLoginRepository.findUserRequestLoginByUserId(id);
	}
	
}
