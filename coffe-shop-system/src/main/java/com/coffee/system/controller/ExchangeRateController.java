package com.coffee.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.system.model.dto.ExchangeRateDto;
import com.coffee.system.model.system.ExchangeRate;
import com.coffee.system.service.ExchangeRateService;

@RestController
@RequestMapping("/exchange_rate")
public class ExchangeRateController {
	@Autowired
	private ExchangeRateService ExchangeRateService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ExchangeRate> getExchangeRateById(@PathVariable int id){
		return ResponseEntity.ok(ExchangeRateService.getExchangeRateById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<ExchangeRate>> getExchangeRateById(){
		return ResponseEntity.ok(ExchangeRateService.getExchangeRateList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<ExchangeRate> insertExchangeRate(@RequestBody ExchangeRateDto exchangeRateDto){
		return ResponseEntity.ok(ExchangeRateService.insertExchangeRate(exchangeRateDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ExchangeRate> updateExchangeRate(@PathVariable int id,  @RequestBody ExchangeRateDto exchangeRateDto){
		return ResponseEntity.ok(ExchangeRateService.updateExchangeRate(id, exchangeRateDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteExchangeRate(@PathVariable int id){
		return ResponseEntity.ok(ExchangeRateService.deleteExchangeRate(id));
	}
}
