package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer>{

}