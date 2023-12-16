package com.coffee.system.config.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.config.security.mapper.RoleMapper;
import com.coffee.system.config.security.model.Role;
import com.coffee.system.config.security.repository.RoleRepository;
import com.coffee.system.config.security.service.RoleService;
import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.model.dto.RoleDto;
import com.coffee.system.util.ErrorUtil;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository RoleRepository;
    @Autowired
    private RoleMapper roleMapper;
    
	@Override
	public Role getRoleById(int id){
		Optional<Role> role= RoleRepository.findById(id);
		if(role.isEmpty()) {
			System.out.println(">>>>>>>>>> Role Id:"+"Role's id("+id+") not found!");
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Role's id("+id+") not found!");
		}
		System.out.println(">>>>>>>>>> Role Id:"+role.get().getId());
		return role.get();
	}
	
	@Override
	public List<Role> getRoleList(){
		List<Role> listRole= RoleRepository.findAll();
		return listRole;
	}

	@Override
	public Role insertRole(RoleDto RoleDto) {
		Role Role = roleMapper.toRole(RoleDto);
		return RoleRepository.save(Role);
	}

	@Override
	public Role updateRole(int id, RoleDto RoleDto) {
		getRoleById(id);
		Role role = roleMapper.toRole(RoleDto);
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
