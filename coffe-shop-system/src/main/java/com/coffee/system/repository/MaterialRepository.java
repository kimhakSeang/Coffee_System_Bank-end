package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.entity.Category;
import com.coffee.system.model.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer>{

}
