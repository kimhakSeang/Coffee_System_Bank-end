package com.coffee.system.model.dto;

import java.util.List;

import com.coffee.system.model.entity.PreOrderStatus;

import lombok.Data;

@Data
public class PreOrderDto {
	
	private List<Integer> customersId;
	private List<Integer> itemsId;
	private PreOrderStatus orderStatus;
}
