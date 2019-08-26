package com.gocarting;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface AddCart {
    Boolean addCart(String id);
}

public class Cart {
    // List of products inside our cart
    private List<Item> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    /**
     * Returns the sum of all elements in {@code cartItems}.
     * If the cart is empty, returns 0.
     */
    public Double getCartSum() {
        if (cartItems.size() > 0) {
            return  cartItems.stream()
                    .map(x -> x.getPrice())
                    .reduce(0.0, Double::sum);
        }
        return 0.0;
    }

    /**
     * Attempts to add a new element to our shopping cart.
     * Item is looked up using {@code itemID}.
     */
    public Boolean addCartItem(String itemID) {
        AddCart a = id->{
            Item item = ItemData.searchByItemID(id);
            if (item == null) return false;
            cartItems.add(item);
            return true;

        };
        a.addCart(itemID);
        Item addedItem = ItemData.searchByItemID(itemID);
        if (addedItem == null) {
            //@TODO handle this exception!
        }
        else {
            cartItems.add(addedItem);
        }
    }
}
