package com.gocarting.service;

import com.gocarting.item.Item;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    Double getCartSum();

    String addToCart(String id);

    String removeFromCart(String id);

    Item getCheapestItem();

    Item getPriciestItem();
}
