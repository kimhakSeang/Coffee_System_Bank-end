package com.coffee.system.model.dto;

import java.util.List;

import com.coffee.system.config.security.model.RoleEnum;

import lombok.Data;

@Data
public class RoleDto {
	private RoleEnum role;
	private String useYN;
	private List<Integer> permissionId;
}
