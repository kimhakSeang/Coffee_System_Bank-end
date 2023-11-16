package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.PreOrderMapper;
import com.coffee.system.model.dto.PreOrderDto;
import com.coffee.system.model.system.PreOrder;
import com.coffee.system.repository.PreOrderRepository;
import com.coffee.system.service.PreOrderService;
import com.coffee.system.util.ErrorUtil;
@Service
public class PreOrderServiceImpl implements PreOrderService{
	@Autowired
    private PreOrderRepository preOrderRepository;
    
	@Override
	public PreOrder getPreOrderById(int id){
		Optional<PreOrder> preOrder= preOrderRepository.findById(id);
		if(preOrder.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"PreOrder's id("+id+") not found!");
		}
		return preOrder.get();
	}
	
	@Override
	public List<PreOrder> getPreOrderList() {
		return preOrderRepository.findAll();
	}

	@Override
	public PreOrder insertPreOrder(PreOrderDto preOrderDto) {
		PreOrder PreOrder = PreOrderMapper.INSTANCE.toPreOrder(preOrderDto);
		preOrderRepository.save(PreOrder);
		return PreOrder;
	}

	@Override
	public PreOrder updatePreOrder(int id, PreOrderDto preOrderDto) {
		getPreOrderById(id);
		PreOrder preOrder = PreOrderMapper.INSTANCE.toPreOrder(preOrderDto);
		preOrder.setId(id);
		return preOrderRepository.save(preOrder);
	}
	@Override
	public String deletePreOrder(int id) {
		getPreOrderById(id);
		preOrderRepository.deleteById(id);
		return "Delete Success.";
	}
}
