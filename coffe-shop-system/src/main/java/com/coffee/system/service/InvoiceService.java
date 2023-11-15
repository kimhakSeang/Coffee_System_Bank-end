package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.Invoice;
import com.coffee.system.model.dto.InvoiceDto;

public interface InvoiceService {

    Invoice getInvoiceById(int id);
    
    List<Invoice> getInvoiceList();
    
    Invoice insertInvoice(InvoiceDto invoiceDto);
    
    Invoice updateInvoice(int id, InvoiceDto invoiceDto);
    
    String deleteInvoice(int id);
}
