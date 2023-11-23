package com.coffee.system.config.security.model;

public enum RoleEnum {
	  USER("USER", "Normal User")
	, ADMIN("ADMIN", "Admin User")
	, CASHIER("CASHIER", "Cashier User")
	, SERVICE("SERVICE", "Service User")
	, CSUTOMER("CSUTOMER", "Customer User");
	
	private String name, detail;
	
	RoleEnum(String name, String detail){
		this.name = name;
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
