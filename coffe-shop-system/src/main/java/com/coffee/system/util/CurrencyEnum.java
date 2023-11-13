package com.coffee.system.util;

public enum CurrencyEnum {
	
	USD(1, "USD", "$"),
	KHR(1, "USD", "៛"),
	EUR(1, "USD", "€"),
	VND(1, "USD", "₫"),
	THB(1, "THB", "฿");
	
	private int code;
	private String name, represent;
	
	CurrencyEnum(int code, String name , String represent){
		this.code = code;
		this.name = name;
		this.represent = represent;
	}
    
	public Integer getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getRepInteger() {
		return represent;
	}
}