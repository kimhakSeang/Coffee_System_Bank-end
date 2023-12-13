package com.coffee.system.config.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coffee.system.config.security.mapper.RequestLoginMapper;
import com.coffee.system.config.security.model.RequestLogin;
import com.coffee.system.config.security.model.User;
import com.coffee.system.config.security.service.UserLoginService;
import com.coffee.system.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserLoginService userLoginService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> getUser = userRepository.findAll().stream()
				.filter(u -> u.getEmail().equals(email)).findFirst();
         
		if (getUser.isPresent()) {
			RequestLogin userRequestLogin = userLoginService.getUserRequestLogin(getUser.get().getId());
			log.info(">>> userRequestLogin:"+userRequestLogin);
			
			return RequestLoginMapper.INSTANCE.toUserLoginDetail(userRequestLogin);
		}
		log.error("Email not exist!");
		throw new RuntimeException("Email not exist!");
	};

}
