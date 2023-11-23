package com.coffee.system.config.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.config.security.model.UserRequestLogin;

public interface UserLoginRepository extends JpaRepository<UserRequestLogin, Integer>{
	
	Optional<UserRequestLogin> getUserRequestLoginByEmail(String email);
}
