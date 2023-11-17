package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.user.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
