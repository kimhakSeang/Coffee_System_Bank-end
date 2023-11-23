package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.PreOrderDto;
import com.coffee.system.model.entity.PreOrder;

public interface PreOrderService {

    PreOrder getPreOrderById(int id);
    
    List<PreOrder> getPreOrderList();
    
    PreOrder insertPreOrder(PreOrderDto preOrderDto);
    
    PreOrder updatePreOrder(int id, PreOrderDto preOrderDto);
    
    String deletePreOrder(int id);
}
