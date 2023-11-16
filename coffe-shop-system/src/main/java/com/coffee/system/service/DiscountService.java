package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.DiscountDto;
import com.coffee.system.model.system.Discount;

public interface DiscountService {

    Discount getDiscountById(int id);
    
    List<Discount> getDiscountList();
    
    Discount insertDiscount(DiscountDto discountDto);
    
    Discount updateDiscount(int id, DiscountDto discountDto);
    
    String deleteDiscount(int id);
}
