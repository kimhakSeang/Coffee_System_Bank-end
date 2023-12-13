package com.coffee.system.config.security.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.mapper.UserLoginMapper;
import com.coffee.system.config.security.model.RequestLogin;
import com.coffee.system.config.security.repository.UserLoginRepository;
import com.coffee.system.config.security.service.UserLoginService;
import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.util.ErrorUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRequestLoginServiceImpl implements UserLoginService{
    private final UserLoginRepository userLoginRepository;
    private final UserLoginMapper userLoginMapper;
    private final PasswordEncoder encoder;
    
	@Override
	public RequestLogin register( UserLoginDto userLoginDto) {
//		userLoginDto.setAccountNonExpired(true);
//		userLoginDto.setAccountNonLocked(true);
//		userLoginDto.setCredentialsNonExpired(true);
//		userLoginDto.setEnabled(true);
//		userLoginDto.setRoleId(1);
		userLoginDto.setPassword(encoder.encode(userLoginDto.getPassword()));
		RequestLogin userRequestLogin = userLoginMapper.toUserRequestLogin(userLoginDto);
		
		

//
//try {
//	
////	// Validate Email duplicate 
////	Optional<EmailToken> checkEmail = emailService.getAll()
////			   		.stream()
////			   		.filter(u->u.getUserLogin().getEmail().equals(userLoginDto.getEmail()))
////			   		.findFirst();
////	if(checkEmail.isPresent()) {
////		throw new RuntimeExceptionImpl(ErrorUtil.READY_EXIST, "Email is ready exist!!");
////	}
////	
////	// Register User Login
////	UserRequestLogin userRequestLogin = userLoginService.register(userLoginDto);
////	UserDto userDto = userMapper.toUserDto(userRequestLogin.getUser());
////	
//	//TODO 
//	// Register User
////	userService.insertUser(userDto);
//	// Check User Info
////	Optional<User> userByEmail = userService.getUserByEmail(userDto.getEmail());
////
////	if(checkEmail.isPresent()) {
////		throw new RuntimeExceptionImpl(ErrorUtil.READY_EXIST, "Email is ready exist!!");
////	}
////	
//	// Email Sender
////	String token = emailService.signUp(new EmailTokenDto("", false, userRequestLogin.getId(),null, null,null));
////	EmailToken getEmailToken = emailService.findEmailByToken(token);
////	emailService.sender(getEmailToken, userLoginDto.getUsername());
////	
////	System.out.println(">>>>>>>>>>>>>> Token:"+token);
//	return ResponseEntity.ok("Register success!");
//	
//}catch(Exception ex) {
//	throw ex;
		
		
		
		
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
	
}
