package com.coffee.system.config.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.mapper.RequestLoginMapper;
import com.coffee.system.config.security.model.RequestLogin;
import com.coffee.system.config.security.model.User;
import com.coffee.system.config.security.service.UserLoginService;
import com.coffee.system.config.security.service.UserService;
import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.util.ErrorUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private RequestLoginMapper requestLoginMapper;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userOptional = userService.getUserByEmail(email);
		//Check User
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			log.info(">>> userRequestLogin:"+user);
			
			Optional<RequestLogin> userRequestLogin = userLoginService.getUserRequestLoginByUserId(user.getId());
			
			//Check user login
			//If exist return:else register
			if(userRequestLogin.isPresent()) {
				return requestLoginMapper.toUserLoginDetail(userRequestLogin.get());
			}
			
			RequestLogin userLogin = userLoginService.register(new UserLoginDto(user.getEmail(), user.getPassword()));
			userLogin.setAccountNonExpired(true);
			userLogin.setAccountNonLocked(true);
			userLogin.setCredentialsNonExpired(true);
			userLogin.setEnabled(true);
			userLogin.setUser(user);
			
			return requestLoginMapper.toUserLoginDetail(userLogin);
		}
		
		log.error("Email not exist!");
		throw new RuntimeExceptionImpl(ErrorUtil.BAD_REQUEST, "Email not exist!");
	};

}
