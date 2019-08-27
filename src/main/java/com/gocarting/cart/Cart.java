package com.gocarting.cart;

import com.gocarting.item.Item;
import com.gocarting.repository.ItemRepository;

import java.util.HashMap;

public class Cart {

    private final HashMap<Item, Integer> cartItems = new HashMap<>();

    private ItemRepository itemRepository;
    private Double cartSum = 0.0;

    public Cart(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * Returns the sum of all elements in {@code cartItems}.
     * If the cart is empty, returns 0.0.
     */
    public Double getCartSum() {
        return cartSum;
    }

    /**
     * Returns true if cart contains {@code itemID}, and false otherwise.
     */
    public Boolean hasItem(String itemID) {
        return cartItems.containsKey(itemRepository.getItem(itemID));
    }

    /**
     * Returns amount of occurences for a given item object.
     */
    public int getItemAmount(Item item) {
        return cartItems.get(item);
    }

    /**
     * Attempts to add an item to cart by {@code itemID}.
     * Returns true on success, false otherwise.
     */
    public Boolean addToCart(String itemID) {
        if (!itemRepository.hasItem(itemID)) {
            return false;
        }
        Item addedItem = itemRepository.getItem(itemID);
        if (cartItems.containsKey(addedItem)) {
            // Support multiple items of same kind inside cart.
            cartItems.put(addedItem, cartItems.get(addedItem) + 1);
        } else {
            cartItems.put(addedItem, 1);
        }
        cartSum += addedItem.getPrice();
        return true;
    }

    /**
     * Attempts to remove an item from the cart by {@code itemID}.
     * Returns true upon successful removal, and false otherwise.
     */
    public Boolean removeFromCart(String itemID) {
        if (!this.hasItem(itemID)) {
            return false;
        }
        Item removedItem = itemRepository.getItem(itemID);
        if (cartItems.get(removedItem) == 1) {
            cartItems.remove(removedItem);
        }
        else {
            // Support multiple items of same kind inside cart.
            cartItems.put(removedItem, cartItems.get(removedItem) - 1);
        }
        cartSum -= removedItem.getPrice();
        return true;
    }
}
