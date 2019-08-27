package com.gocarting.cart;

import com.gocarting.item.Item;
import com.gocarting.item.ItemRepository;

import java.util.HashMap;

public class Cart {

    private final HashMap<Item, Integer> cartItems = new HashMap<>();

    private ItemRepository itemRepository;
    private Double cartSum;

    public Cart(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Double getCartSum() {
        return cartSum;
    }

    public Boolean hasItem(String itemID) {
        return cartItems.containsKey(itemRepository.getItem(itemID));
    }

    public Boolean addToCart(String itemID) {
        if (!itemRepository.hasItem(itemID)) {
            return false;
        }
        Item addedItem = itemRepository.getItem(itemID);
        if (cartItems.containsKey(addedItem)) {
            cartItems.put(addedItem, cartItems.get(addedItem) + 1);
        } else {
            cartItems.put(addedItem, 1);
        }
        cartSum += addedItem.getPrice();
        return true;
    }

    public Boolean removeFromCart(String itemID) {
        if (!this.hasItem(itemID)) {
            return false;
        }
        Item removedItem = itemRepository.getItem(itemID);
        cartItems.remove(removedItem);
        cartSum -= removedItem.getPrice();
        return true;
    }
}
