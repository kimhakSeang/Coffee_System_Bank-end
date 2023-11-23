package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
