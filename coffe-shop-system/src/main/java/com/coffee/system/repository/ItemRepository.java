package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
