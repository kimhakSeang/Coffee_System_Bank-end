package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.PreOrder;

public interface PreOrderRepository extends JpaRepository<PreOrder, Integer>{

}