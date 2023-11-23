package com.coffee.system.config.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.config.security.model.UserPermission;


public interface PermissionRepository extends JpaRepository<UserPermission, Integer>{

}
