package com.coffee.system.service;

import java.util.Map;

public interface ReportService {
	
	Map<String, String> getDailyReport();
	
	Map<String, String> getMonthlyReport();
	
	Map<String, String> getAnnualyReport();
 
}
