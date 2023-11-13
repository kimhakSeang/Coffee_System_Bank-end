package com.coffee.system.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.model.Invoice;
import com.coffee.system.repository.InvoiceRepository;
import com.coffee.system.service.InvoiceService;
import com.coffee.system.util.ErrorUtil;
@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
    private InvoiceRepository invoiceRepository;
    
	@Override
	public Invoice getInvoiceById(int id){
		Optional<Invoice> invoice= invoiceRepository.findById(id);
		if(invoice.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Invoice's id("+id+") not found!");
		}
		return invoice.get();
	}

	@Override
	public Invoice insertInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@Override
	public Invoice updateInvoice(Invoice invoice) {
		getInvoiceById(invoice.getId());
		return invoiceRepository.save(invoice);
	}

	@Override
	public String deleteInvoice(int id) {
		getInvoiceById(id);
		invoiceRepository.deleteById(id);
		return "Delete Success.";
	}

}
