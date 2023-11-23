package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
