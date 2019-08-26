package com.gocarting.service;

public interface CartService {

    // Sum elements of the cart
    Double getCartSum();

    // Add an element to the cart
    Boolean addToCart(String id);
}
