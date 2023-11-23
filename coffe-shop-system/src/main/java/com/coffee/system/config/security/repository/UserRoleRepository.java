package com.coffee.system.config.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.config.security.model.Role;

public interface UserRoleRepository extends JpaRepository<Role, Integer>{

}
