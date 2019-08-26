package com.gocarting.service;

import java.util.HashMap;
import java.util.stream.Collectors;

import com.gocarting.item.Item;

public class CartServiceImpl implements CartService {
    // List of products inside our cart
    private HashMap<String, Item> cartItems;

    // Items service for our shopping cart
    private ItemService itemsService;

    // No-Args ctr
    public CartServiceImpl() {

        cartItems = new HashMap<>();
        itemsService = new ItemServiceImpl();
    }

    /**
     * Returns the sum of all elements in {@code cartItems}.
     * If the cart is empty, returns 0.
     */
    @Override
    public Double getCartSum() {
        if (cartItems.size() > 0) {
            return  cartItems.values()
                    .stream()
                    .collect(Collectors.summarizingDouble(item-> item.getPrice()))
                    .getSum();
        }
        return 0.0;
    }

    /**
     * Attempts to add an item to cart by {@code id}.
     * Returns true on success, false otherwise.
     */
    @Override
    public Boolean addToCart(String id) {

        if (itemsService.searchItemByID(id)) {
            cartItems.put(id, itemsService.getItemByID(id));
            return true;
        }
        return false;
    }
}
