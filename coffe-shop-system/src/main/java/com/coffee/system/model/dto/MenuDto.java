package com.coffee.system.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class MenuDto {

	private int id;
	private List<Integer> itemId;

}
