package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.RoleDto;
import com.coffee.system.model.user.Role;

public interface RoleService {
	
       Role getRoleById(int id);

       List<Role> getRoleList();
       
       Role insertRole(RoleDto Role);
       
       Role updateRole(int id, RoleDto Role);
       
       String deleteRole(int id);
}
