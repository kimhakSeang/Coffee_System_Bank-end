package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.system.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
