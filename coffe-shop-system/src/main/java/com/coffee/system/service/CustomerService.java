package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.CustomerDto;
import com.coffee.system.model.entity.Customer;

public interface CustomerService {

    Customer getCustomerById(int id);
    
    List<Customer> getCustomerList();
    
    Customer insertCustomer(CustomerDto customerDto);
    
    Customer updateCustomer(int id, CustomerDto customerDto);
    
    String deleteCustomer(int id);
}
