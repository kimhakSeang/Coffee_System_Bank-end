package com.coffee.system.config.security.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.mapper.UserLoginMapper;
import com.coffee.system.config.security.model.UserRequestLogin;
import com.coffee.system.config.security.repository.UserLoginRepository;
import com.coffee.system.config.security.service.UserLoginService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRequestLoginServiceImpl implements UserLoginService{
    private final UserLoginRepository userLoginRepository;
    private final UserLoginMapper userLoginMapper;
//    private final PasswordEncoder encoder;
    
	@Override
	public UserRequestLogin register( UserLoginDto userLoginDto) {
		
		userLoginDto.setAccountNonExpired(true);
		userLoginDto.setAccountNonLocked(true);
		userLoginDto.setCredentialsNonExpired(true);
		userLoginDto.setEnabled(true);
		userLoginDto.setRoleId(1);
//		userLoginDto.setPassword(encoder.encode(userLoginDto.getPassword()));
        
		return userLoginRepository.save(userLoginMapper.toUserRequestLogin(userLoginDto));
	} 

	@Override
	public void update(int id, UserLoginDto userLoginDto) {
		Optional<UserRequestLogin> getUserLogin = userLoginRepository.findById(id);
		if(getUserLogin.isEmpty()) {
			throw new RuntimeException("User login is not exist!");
		}
		UserRequestLogin userRequestLogin = userLoginMapper.toUserRequestLogin(userLoginDto);
		userLoginRepository.save(userRequestLogin);
	}

	@Override
	public UserRequestLogin getUserRequestLogin(int id) {
		Optional<UserRequestLogin> getUserLogin = userLoginRepository.findById(id);
		if(getUserLogin.isEmpty()||!getUserLogin.get().isEnabled()) {
			throw new RuntimeException("User login is not exist!");
		}
		return getUserLogin.get();
	}

	@Override
	public List<UserRequestLogin> getListUserLogin() {
		return userLoginRepository.findAll();
	}

	@Override
	public void delete(int id) {
		Optional<UserRequestLogin> getUserLogin = userLoginRepository.findById(id);
		if(getUserLogin.isEmpty()) {
			throw new RuntimeException("User login is not exist!");
		}
		UserRequestLogin userRequestLogin = getUserLogin.get();
		userRequestLogin.setEnabled(false);
		userLoginRepository.save(userRequestLogin);
	}
	
}
