package com.coffee.system.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.model.PreOrder;
import com.coffee.system.repository.PreOrderRepository;
import com.coffee.system.service.PreOrderService;
import com.coffee.system.util.ErrorUtil;
@Service
public class PreOrderServiceImpl implements PreOrderService{
	@Autowired
    private PreOrderRepository PreOrderRepository;
    
	@Override
	public PreOrder getPreOrderById(int id){
		Optional<PreOrder> PreOrder= PreOrderRepository.findById(id);
		if(PreOrder.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"PreOrder's id("+id+") not found!");
		}
		return PreOrder.get();
	}

	@Override
	public PreOrder insertPreOrder(PreOrder PreOrder) {
		return PreOrderRepository.save(PreOrder);
	}

	@Override
	public PreOrder updatePreOrder(PreOrder PreOrder) {
		getPreOrderById(PreOrder.getId());
		return PreOrderRepository.save(PreOrder);
	}

	@Override
	public String deletePreOrder(int id) {
		getPreOrderById(id);
		PreOrderRepository.deleteById(id);
		return "Delete Success.";
	}
}
