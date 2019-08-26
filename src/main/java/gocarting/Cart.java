package gocarting;

import java.util.List;

public class Cart {
    // List of products inside our cart
    private List<Item> cartItems;

    /**
     * Returns the sum of all elements in {@code cartItems}.
     * If the cart is empty, returns 0.
     */
    public Double getCartSum() {
        if (cartItems.size() > 0) {
            return   cartItems.stream()
                    .map(x -> x.getPrice())
                    .reduce(0.0, Double::sum);
        }
        return 0.0;
    }

    public void addCartItem(String itemID) {
        Item addedItem = ItemData.searchByItemID(itemID);
        if (addedItem == null) {
            //@TODO handle this exception!
        }
        else {
            cartItems.add(addedItem);
        }
    }
}
