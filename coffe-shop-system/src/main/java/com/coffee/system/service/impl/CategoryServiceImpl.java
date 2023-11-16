package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.CategoryMapper;
import com.coffee.system.model.dto.CategoryDto;
import com.coffee.system.model.system.Category;
import com.coffee.system.repository.CategoryRepository;
import com.coffee.system.service.CategoryService;
import com.coffee.system.util.ErrorUtil;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    
	@Override
	public Category getCategoryById(int id){
		Optional<Category> category= categoryRepository.findById(id);
		if(category.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Category's id("+id+") not found!");
		}
		return category.get();
	}
	
	@Override
	public List<Category> getCategoryList(){
		List<Category> listCategory= categoryRepository.findAll();
		return listCategory;
	}

	@Override
	public Category insertCategory(CategoryDto categoryDto) {
		Category category = categoryMapper.toCategory(categoryDto);
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(int id, CategoryDto categoryDto) {
		Category category = getCategoryById(id);
		category.setName(categoryDto.getName());
		return categoryRepository.save(category);
	}

	@Override
	public String deleteCategory(int id) {
		getCategoryById(id);
		categoryRepository.deleteById(id);
		return "Delete Success.";
	}

}
