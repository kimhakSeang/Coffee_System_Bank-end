package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.Item;
import com.coffee.system.model.dto.ItemDto;

public interface ItemService {

    Item getItemById(int id);
    
    List<Item> getItemList();
    
    Item insertItem(ItemDto itemDto);
    
    Item updateItem(int id, ItemDto itemDto);
    
    String deleteItem(int id);
}
