package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.ItemMapper;
import com.coffee.system.model.dto.ItemDto;
import com.coffee.system.model.entity.Item;
import com.coffee.system.repository.ItemRepository;
import com.coffee.system.service.ItemService;
import com.coffee.system.util.ErrorUtil;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
    private ItemRepository itemRepository;
    
	@Override
	public Item getItemById(int id){
		Optional<Item> item= itemRepository.findById(id);
		if(item.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Item's id("+id+") not found!");
		}
		return item.get();
	}
	
	@Override
	public List<Item> getItemList() {
		return itemRepository.findAll();
	}

	@Override
	public Item insertItem(ItemDto itemDto) {
		Item item = ItemMapper.INSTANCE.toItem(itemDto);
		itemRepository.save(item);
		return item;
	}

	@Override
	public Item updateItem(int id, ItemDto itemDto) {
		getItemById(id);
		Item item = ItemMapper.INSTANCE.toItem(itemDto);
		item.setId(id);
		return itemRepository.save(item);
	}
	@Override
	public String deleteItem(int id) {
		getItemById(id);
		itemRepository.deleteById(id);
		return "Delete Success.";
	}

}
