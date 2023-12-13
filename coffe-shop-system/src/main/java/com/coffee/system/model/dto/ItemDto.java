package com.coffee.system.model.dto;

import com.coffee.system.model.entity.ItemType;

import lombok.Data;

@Data
public class ItemDto {

	private String name;
	private Integer categoryId;
	private long price;
    private long sugar;
	private ItemType type;
}
