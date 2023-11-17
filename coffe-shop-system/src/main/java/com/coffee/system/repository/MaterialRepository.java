package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.system.Category;
import com.coffee.system.model.system.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer>{

}
