package com.coffee.system.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DiscountDto {
	private double percent;
	private Date fromDate;
	private Date toDate;
}
