package com.gocarting.service;

import com.gocarting.item.Item;

public interface CartService {

    Double getCartSum();

    Boolean addToCart(String id);

    Item getCheapestItem();

    Item getPriciestItem();
}
