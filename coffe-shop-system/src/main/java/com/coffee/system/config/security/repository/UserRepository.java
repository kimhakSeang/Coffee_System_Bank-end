package com.coffee.system.config.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.config.security.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findUserByEmail(String email);
}
