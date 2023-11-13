package com.coffee.system.service;

import com.coffee.system.model.Invoice;

public interface InvoiceService {

	Invoice getInvoiceById(int id);
    
    Invoice insertInvoice(Invoice invoice);
    
    Invoice updateInvoice(Invoice invoice);
    
    String deleteInvoice(int id);
}
