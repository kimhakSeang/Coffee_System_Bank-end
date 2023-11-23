package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.config.security.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
