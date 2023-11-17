package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.RoleMapper;
import com.coffee.system.model.dto.RoleDto;
import com.coffee.system.model.user.Role;
import com.coffee.system.repository.RoleRepository;
import com.coffee.system.service.RoleService;
import com.coffee.system.util.ErrorUtil;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository RoleRepository;
    
	@Override
	public Role getRoleById(int id){
		Optional<Role> Role= RoleRepository.findById(id);
		if(Role.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Role's id("+id+") not found!");
		}
		return Role.get();
	}
	
	@Override
	public List<Role> getRoleList(){
		List<Role> listRole= RoleRepository.findAll();
		return listRole;
	}

	@Override
	public Role insertRole(RoleDto RoleDto) {
		Role Role = RoleMapper.INSTANCE.toRole(RoleDto);
		return RoleRepository.save(Role);
	}

	@Override
	public Role updateRole(int id, RoleDto RoleDto) {
		getRoleById(id);
		Role role = RoleMapper.INSTANCE.toRole(RoleDto);
		role.setId(id);
		return RoleRepository.save(role);
	}

	@Override
	public String deleteRole(int id) {
		getRoleById(id);
		RoleRepository.deleteById(id);
		return "Delete Success.";
	}

}
