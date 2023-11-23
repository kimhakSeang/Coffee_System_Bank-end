package com.coffee.system.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.config.security.model.UserPermission;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Integer> {

}
