package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.InvoiceMapper;
import com.coffee.system.model.dto.InvoiceDto;
import com.coffee.system.model.system.Invoice;
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
	public List<Invoice> getInvoiceList() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice insertInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(invoiceDto);
		invoiceRepository.save(invoice);
		return invoice;
	}

	@Override
	public Invoice updateInvoice(int id, InvoiceDto invoiceDto) {
		getInvoiceById(id);
		Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(invoiceDto);
		invoice.setId(id);
		return invoiceRepository.save(invoice);
	}
	@Override
	public String deleteInvoice(int id) {
		getInvoiceById(id);
		invoiceRepository.deleteById(id);
		return "Delete Success.";
	}

}
