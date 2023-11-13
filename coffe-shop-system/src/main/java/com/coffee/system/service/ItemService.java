package com.coffee.system.service;

import com.coffee.system.model.Item;

public interface ItemService {

    Item getItemById(int id);
    
    Item insertItem(Item item);
    
    Item updateItem(Item item);
    
    String deleteItem(int id);
}
