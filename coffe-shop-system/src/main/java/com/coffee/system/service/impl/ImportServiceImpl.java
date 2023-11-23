package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.ImportMapper;
import com.coffee.system.model.dto.ImportDto;
import com.coffee.system.model.entity.Import;
import com.coffee.system.repository.ImportRepository;
import com.coffee.system.service.ImportService;
import com.coffee.system.util.ErrorUtil;
@Service
public class ImportServiceImpl implements ImportService{
	@Autowired
    private ImportRepository importRepository;
    
	@Override
	public Import getImportById(int id){
		Optional<Import> Import= importRepository.findById(id);
		if(Import.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Import's id("+id+") not found!");
		}
		return Import.get();
	}
	
	@Override
	public List<Import> getImportList() {
		return importRepository.findAll();
	}

	@Override
	public Import insertImport(ImportDto ImportDto) {
		Import Import = ImportMapper.INSTANCE.toImport(ImportDto);
		importRepository.save(Import);
		return Import;
	}

	@Override
	public Import updateImport(int id, ImportDto ImportDto) {
		getImportById(id);
		Import Import = ImportMapper.INSTANCE.toImport(ImportDto);
		Import.setId(id);
		return importRepository.save(Import);
	}
	@Override
	public String deleteImport(int id) {
		getImportById(id);
		importRepository.deleteById(id);
		return "Delete Success.";
	}
}
