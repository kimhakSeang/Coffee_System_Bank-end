package com.coffee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.system.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
