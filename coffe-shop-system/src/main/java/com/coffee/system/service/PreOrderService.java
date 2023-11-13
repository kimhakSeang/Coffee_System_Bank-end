package com.coffee.system.service;

import com.coffee.system.model.PreOrder;

public interface PreOrderService {

    PreOrder getPreOrderById(int id);
    
    PreOrder insertPreOrder(PreOrder preOrder);
    
    PreOrder updatePreOrder(PreOrder preOrder);
    
    String deletePreOrder(int id);
}
