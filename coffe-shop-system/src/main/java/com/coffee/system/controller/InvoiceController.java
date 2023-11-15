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

import com.coffee.system.model.Invoice;
import com.coffee.system.model.dto.InvoiceDto;
import com.coffee.system.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService InvoiceService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable int id){
		return ResponseEntity.ok(InvoiceService.getInvoiceById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Invoice>> getInvoiceById(){
		return ResponseEntity.ok(InvoiceService.getInvoiceList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Invoice> insertInvoice(@RequestBody InvoiceDto invoiceDto){
		return ResponseEntity.ok(InvoiceService.insertInvoice(invoiceDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Invoice> updateInvoice(@PathVariable int id,  @RequestBody InvoiceDto invoiceDto){
		return ResponseEntity.ok(InvoiceService.updateInvoice(id, invoiceDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteInvoice(@PathVariable int id){
		return ResponseEntity.ok(InvoiceService.deleteInvoice(id));
	}
}
