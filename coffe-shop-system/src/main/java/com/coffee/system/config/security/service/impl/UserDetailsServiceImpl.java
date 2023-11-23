package com.coffee.system.config.security.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.config.security.mapper.UserRequestLoginMapper;
import com.coffee.system.config.security.repository.UserLoginRepository;
import com.coffee.system.config.security.service.UserLoginService;


@Service
public class UserDetailsServiceImpl /* implements UserDetailsService */{

	@Autowired
	private UserLoginRepository userLoginRepository;
	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private UserRequestLoginMapper requestLoginMapper;
	
	/*
	 * @Override public UserDetails loadUserByUsername(String email) throws
	 * UsernameNotFoundException{ return getUserDetail(email); };
	 * 
	 * private UserDetails getUserDetail(String email) { Optional<UserRequestLogin>
	 * getUser =
	 * userLoginRepository.findAll().stream().filter(u->u.getEmail().equals(email)).
	 * findFirst();
	 * 
	 * if(getUser.isPresent()) { UserRequestLogin userRequestLogin =
	 * userLoginService.getUserRequestLogin(getUser.get().getId()); return
	 * requestLoginMapper.toUserLoginDetail(userRequestLogin); }
	 * 
	 * throw new RuntimeException("Email not exist!"); }
	 */
}
  