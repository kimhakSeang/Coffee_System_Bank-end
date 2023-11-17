package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.MaterialMapper;
import com.coffee.system.model.dto.MaterialDto;
import com.coffee.system.model.system.Material;
import com.coffee.system.repository.MaterialRepository;
import com.coffee.system.service.MaterialService;
import com.coffee.system.util.ErrorUtil;

@Service
public class MaterialServiceImpl implements MaterialService{
	@Autowired
    private MaterialRepository MaterialRepository;
    
	@Override
	public Material getMaterialById(int id){
		Optional<Material> Material= MaterialRepository.findById(id);
		if(Material.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Material's id("+id+") not found!");
		}
		return Material.get();
	}
	
	@Override
	public List<Material> getMaterialList() {
		return MaterialRepository.findAll();
	}

	@Override
	public Material insertMaterial(MaterialDto MaterialDto) {
		Material Material = MaterialMapper.INSTANCE.toMaterial(MaterialDto);
		MaterialRepository.save(Material);
		return Material;
	}

	@Override
	public Material updateMaterial(int id, MaterialDto MaterialDto) {
		getMaterialById(id);
		Material Material = MaterialMapper.INSTANCE.toMaterial(MaterialDto);
		Material.setId(id);
		return MaterialRepository.save(Material);
	}
	@Override
	public String deleteMaterial(int id) {
		getMaterialById(id);
		MaterialRepository.deleteById(id);
		return "Delete Success.";
	}

}
