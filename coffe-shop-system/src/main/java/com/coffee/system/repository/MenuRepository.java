package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.system.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
