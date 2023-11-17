package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.MaterialDto;
import com.coffee.system.model.system.Material;

public interface MaterialService {
	
       Material getMaterialById(int id);

       List<Material> getMaterialList();
       
       Material insertMaterial(MaterialDto Material);
       
       Material updateMaterial(int id, MaterialDto Material);
       
       String deleteMaterial(int id);
}
