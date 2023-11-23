package com.coffee.system.config.security.service;


import java.util.List;

import com.coffee.system.config.security.dto.UserPermissionDto;
import com.coffee.system.config.security.model.UserPermission;

public interface UserPermissionService {
	
	UserPermission register( UserPermissionDto userPermissionDto);
	
	void update(int id, UserPermissionDto userPermissionDto);
	
	String delete(int id);
	
	UserPermission getUserPermission(int id);
	
	List<UserPermission> getListUserLogin();
}
