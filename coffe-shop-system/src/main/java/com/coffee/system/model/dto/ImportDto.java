package com.coffee.system.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ImportDto {
	
	private Integer materialsId;
	private Integer userId;
	private long price;
	private Date importDate;
	private int count;
	private long totalAmount; 
	private String status;
	
	
}
