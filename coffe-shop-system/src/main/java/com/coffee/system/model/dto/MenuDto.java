package com.coffee.system.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class MenuDto {

	private String name;
	private List<Integer> itemId;

}
