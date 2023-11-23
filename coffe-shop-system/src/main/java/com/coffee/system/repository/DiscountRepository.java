package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer>{

}
