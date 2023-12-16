package com.coffee.system.config.security.service;

import java.util.List;

import com.coffee.system.config.security.model.Role;
import com.coffee.system.model.dto.RoleDto;

public interface RoleService {
	
       Role getRoleById(int id);

       List<Role> getRoleList();
       
       Role insertRole(RoleDto Role);
       
       Role updateRole(int id, RoleDto Role);
       
       String deleteRole(int id);
}
