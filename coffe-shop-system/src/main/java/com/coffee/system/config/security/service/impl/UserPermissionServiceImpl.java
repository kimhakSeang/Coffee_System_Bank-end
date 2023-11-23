package com.coffee.system.config.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.config.repository.UserPermissionRepository;
import com.coffee.system.config.security.dto.UserPermissionDto;
import com.coffee.system.config.security.mapper.UserPermissionMapper;
import com.coffee.system.config.security.model.UserPermission;
import com.coffee.system.config.security.service.UserPermissionService;
import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.util.ErrorUtil;
@Service
public class UserPermissionServiceImpl implements UserPermissionService{
	@Autowired
    private UserPermissionRepository UserPermissionRepository;

	@Override
	public UserPermission register(UserPermissionDto userPermissionDto) {
		UserPermission UserPermission = UserPermissionMapper.INSTANCE.toUserPermission(userPermissionDto);
		UserPermissionRepository.save(UserPermission);
		return UserPermission;
	}

	@Override
	public void update(int id, UserPermissionDto userPermissionDto) {
		getUserPermission(id);
		UserPermission UserPermission = UserPermissionMapper.INSTANCE.toUserPermission(userPermissionDto);
		UserPermission.setId(id);
	}

	@Override
	public String delete(int id) {
		getUserPermission(id);
		UserPermissionRepository.deleteById(id);
		return "Delete Success.";
		
	}

	@Override
	public UserPermission getUserPermission(int id) {
		Optional<UserPermission> UserPermission= UserPermissionRepository.findById(id);
		if(UserPermission.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"UserPermission's id("+id+") not found!");
		}
		return UserPermission.get();
	}

	@Override
	public List<UserPermission> getListUserLogin() {
		return UserPermissionRepository.findAll();
	}
}
