package com.coffee.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.service.ImportService;
import com.coffee.system.service.ItemService;
import com.coffee.system.service.PaymentService;
import com.coffee.system.service.ReportService;
import com.coffee.system.service.UserService;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	private ImportService importService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private UserService userService;
	
	@Override
	public Map<String, String> getDailyReport() {
		Map<String, String> report = new HashMap<>();
		
		
		return null;
	}

	@Override
	public Map<String, String> getMonthlyReport() {
		
		return null;
	}

	@Override
	public Map<String, String> getAnnualyReport() {
		
		return null;
	}

}
