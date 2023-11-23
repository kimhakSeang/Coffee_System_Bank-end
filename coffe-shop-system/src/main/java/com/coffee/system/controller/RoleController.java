package com.coffee.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.system.config.security.model.Role;
import com.coffee.system.model.dto.RoleDto;
import com.coffee.system.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService RoleService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable int id){
		return ResponseEntity.ok(RoleService.getRoleById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Role>> getRoleById(){
		return ResponseEntity.ok(RoleService.getRoleList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Role> insertRole(@RequestBody RoleDto RoleDto){
		return ResponseEntity.ok(RoleService.insertRole(RoleDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable int id,  @RequestBody RoleDto RoleDto){
		return ResponseEntity.ok(RoleService.updateRole(id, RoleDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRole(@PathVariable int id){
		return ResponseEntity.ok(RoleService.deleteRole(id));
	}
}
