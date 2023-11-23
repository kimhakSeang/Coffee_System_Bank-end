package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.MaterialCategoryDto;
import com.coffee.system.model.entity.MaterialCategory;

public interface MaterialCategoryService {
	
	   MaterialCategory getMaterialCategoryById(int id);

       List<MaterialCategory> getMaterialCategoryList();
       
       MaterialCategory insertMaterialCategory(MaterialCategoryDto category);
       
       MaterialCategory updateMaterialCategory(int id, MaterialCategoryDto category);
       
       String deleteMaterialCategory(int id);
}
