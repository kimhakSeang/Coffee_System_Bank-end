package com.coffee.system.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ImportDto {
	
	private List<Integer> materialsId;
	
	private Integer userId;
	
	private Date impDate;
	
	private long totalAmount; 
	
	private String status;
	
	
}
