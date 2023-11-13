package com.coffee.system.service;

import com.coffee.system.model.Menu;

public interface MenuService {

    Menu getMenuById(int id);
    
    Menu insertMenu(Menu menu);
    
    Menu updateMenu(Menu menu);
    
    String deleteMenu(int id);
}
