package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.MenuMapper;
import com.coffee.system.model.dto.MenuDto;
import com.coffee.system.model.entity.Menu;
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
	public List<Menu> getMenuList() {
		return menuRepository.findAll();
	}

	@Override
	public Menu insertMenu(MenuDto menuDto) {
		Menu menu = MenuMapper.INSTANCE.toMenu(menuDto);
		menuRepository.save(menu);
		return menu;
	}

	@Override
	public Menu updateMenu(int id, MenuDto menuDto) {
		getMenuById(id);
		Menu menu = MenuMapper.INSTANCE.toMenu(menuDto);
		menu.setId(id);
		return menuRepository.save(menu);
	}
	@Override
	public String deleteMenu(int id) {
		getMenuById(id);
		menuRepository.deleteById(id);
		return "Delete Success.";
	}
}
