package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.Category;
import com.coffee.system.model.dto.CategoryDto;

public interface CategoryService {
	
       Category getCategoryById(int id);

       List<Category> getCategoryList();
       
       Category insertCategory(CategoryDto category);
       
       Category updateCategory(int id, CategoryDto category);
       
       String deleteCategory(int id);
}
