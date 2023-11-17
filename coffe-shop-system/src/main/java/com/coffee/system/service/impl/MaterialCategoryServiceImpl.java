package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.MaterialCategoryMapper;
import com.coffee.system.model.dto.MaterialCategoryDto;
import com.coffee.system.model.system.MaterialCategory;
import com.coffee.system.repository.MaterialCategoryRepository;
import com.coffee.system.service.MaterialCategoryService;
import com.coffee.system.util.ErrorUtil;

@Service
public class MaterialCategoryServiceImpl implements MaterialCategoryService{
	@Autowired
    private MaterialCategoryRepository materialCategoryRepository;
    
	@Override
	public MaterialCategory getMaterialCategoryById(int id){
		Optional<MaterialCategory> MaterialCategory= materialCategoryRepository.findById(id);
		if(MaterialCategory.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"MaterialCategory's id("+id+") not found!");
		}
		return MaterialCategory.get();
	}
	
	@Override
	public List<MaterialCategory> getMaterialCategoryList() {
		return materialCategoryRepository.findAll();
	}

	@Override
	public MaterialCategory insertMaterialCategory(MaterialCategoryDto MaterialCategoryDto) {
		MaterialCategory MaterialCategory = MaterialCategoryMapper.INSTANCE.toMaterialCategory(MaterialCategoryDto);
		materialCategoryRepository.save(MaterialCategory);
		return MaterialCategory;
	}

	@Override
	public MaterialCategory updateMaterialCategory(int id, MaterialCategoryDto MaterialCategoryDto) {
		getMaterialCategoryById(id);
		MaterialCategory MaterialCategory = MaterialCategoryMapper.INSTANCE.toMaterialCategory(MaterialCategoryDto);
		MaterialCategory.setId(id);
		return materialCategoryRepository.save(MaterialCategory);
	}
	@Override
	public String deleteMaterialCategory(int id) {
		getMaterialCategoryById(id);
		materialCategoryRepository.deleteById(id);
		return "Delete Success.";
	}
}
