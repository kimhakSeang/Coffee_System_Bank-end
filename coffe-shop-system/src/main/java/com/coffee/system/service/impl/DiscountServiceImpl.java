package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.DiscountMapper;
import com.coffee.system.model.Discount;
import com.coffee.system.model.dto.DiscountDto;
import com.coffee.system.repository.DiscountRepository;
import com.coffee.system.service.DiscountService;
import com.coffee.system.util.ErrorUtil;
@Service
public class DiscountServiceImpl implements DiscountService{
	@Autowired
    private DiscountRepository discountRepository;
    
	@Override
	public Discount getDiscountById(int id){
		Optional<Discount> discount= discountRepository.findById(id);
		if(discount.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Discount's id("+id+") not found!");
		}
		return discount.get();
	}
	
	@Override
	public List<Discount> getDiscountList() {
		return discountRepository.findAll();
	}

	@Override
	public Discount insertDiscount(DiscountDto discountDto) {
		Discount discount = DiscountMapper.INSTANCE.toDiscount(discountDto);
		discountRepository.save(discount);
		return discount;
	}

	@Override
	public Discount updateDiscount(int id, DiscountDto discountDto) {
		getDiscountById(id);
		Discount discount = DiscountMapper.INSTANCE.toDiscount(discountDto);
		discount.setId(id);
		return discountRepository.save(discount);
	}
	@Override
	public String deleteDiscount(int id) {
		getDiscountById(id);
		discountRepository.deleteById(id);
		return "Delete Success.";
	}

	
}
