package com.coffee.system.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.model.Menu;
import com.coffee.system.repository.MenuRepository;
import com.coffee.system.service.MenuService;
import com.coffee.system.util.ErrorUtil;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
    private MenuRepository menuRepository;
    
	@Override
	public Menu getMenuById(int id){
		Optional<Menu> menu= menuRepository.findById(id);
		if(menu.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Menu's id("+id+") not found!");
		}
		return menu.get();
	}

	@Override
	public Menu insertMenu(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	public Menu updateMenu(Menu menu) {
		getMenuById(menu.getId());
		return menuRepository.save(menu);
	}

	@Override
	public String deleteMenu(int id) {
		getMenuById(id);
		menuRepository.deleteById(id);
		return "Delete Success.";
	}
}
