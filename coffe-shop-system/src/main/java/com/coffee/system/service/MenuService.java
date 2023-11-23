package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.MenuDto;
import com.coffee.system.model.entity.Menu;

public interface MenuService {

    Menu getMenuById(int id);
    
    List<Menu> getMenuList();
    
    Menu insertMenu(MenuDto menuDto);
    
    Menu updateMenu(int id, MenuDto menuDto);
    
    String deleteMenu(int id);
}
