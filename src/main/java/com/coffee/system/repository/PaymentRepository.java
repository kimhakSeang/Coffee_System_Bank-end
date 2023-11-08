package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.Item;

public interface PaymentRepository extends JpaRepository<Item, Integer>{

}
