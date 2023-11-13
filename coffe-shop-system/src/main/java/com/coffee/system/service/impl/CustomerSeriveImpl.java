package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.CustomerMapper;
import com.coffee.system.model.Customer;
import com.coffee.system.model.dto.CustomerDto;
import com.coffee.system.repository.CustomerRepository;
import com.coffee.system.service.CustomerService;
import com.coffee.system.util.ErrorUtil;

@Service
public class CustomerSeriveImpl implements CustomerService{
	@Autowired
    private CustomerRepository CustomerRepository;
	@Autowired
	private CustomerMapper customerMapper;
    
	@Override
	public Customer getCustomerById(int id){
		Optional<Customer> customer= CustomerRepository.findById(id);
		if(customer.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Customer's id("+id+") not found!");
		}
		return customer.get();
	}
	
	@Override
	public String deleteCustomer(int id) {
		getCustomerById(id);
		CustomerRepository.deleteById(id);
		return "Delete Success.";
	}

	@Override
	public List<Customer> getCustomerList() {
		return CustomerRepository.findAll();
	}

	@Override
	public Customer insertCustomer(CustomerDto customerDto) {
		Customer customer = customerMapper.toCustomer(customerDto);
		return CustomerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(int id, CustomerDto customerDto) {
		Customer getCustomer = getCustomerById(id);
		Customer customer = customerMapper.toCustomer(customerDto);
		customer.setId(getCustomer.getId());
		return CustomerRepository.save(customer);
	}
}
