package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.ImportDto;
import com.coffee.system.model.entity.Import;

public interface ImportService {

    Import getImportById(int id);
    
    List<Import> getImportList();
    
    Import insertImport(ImportDto importDto);
    
    Import updateImport(int id, ImportDto importDto);
    
    String deleteImport(int id);
}
