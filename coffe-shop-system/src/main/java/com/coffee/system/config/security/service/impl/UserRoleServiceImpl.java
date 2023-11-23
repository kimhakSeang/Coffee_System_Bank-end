package com.coffee.system.config.security.service.impl;


import org.springframework.stereotype.Service;

import com.coffee.system.config.security.model.Role;
import com.coffee.system.config.security.repository.UserRoleRepository;
import com.coffee.system.config.security.service.UserRoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService{
	private  final UserRoleRepository repository;
	
	@Override
	public Role getRoleById(int id) {
		
		return repository.findById(id)
				.orElseThrow(()-> new RuntimeException("RoleID:%s not exist!".formatted(id)));
	}

}
