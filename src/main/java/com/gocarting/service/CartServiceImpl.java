package com.gocarting.service;

import java.util.Comparator;

import com.gocarting.cart.Cart;
import com.gocarting.item.Item;
import com.gocarting.repository.ItemRepository;

import static com.gocarting.controller.CartController.ItemNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.collect.MinMaxPriorityQueue;

@Service
@Component
public class CartServiceImpl implements CartService {

    private Cart cart;
    private Double cartSum = 0.0;
    private ItemRepository itemsRepository;

    private final Comparator<Item> itemComparator =
                  Comparator.comparing(Item::getPrice);
    // Min-Max heap maintains cheapest and most expensive item efficiently
    @SuppressWarnings("UnstableApiUsage")
    private final MinMaxPriorityQueue<Item> itemHeap =
                  MinMaxPriorityQueue.orderedBy(itemComparator).create();

    public CartServiceImpl(ItemRepository itemRepository) {
        this.itemsRepository = itemRepository;
        this.cart = new Cart(itemRepository);
    }

    /**
     * Returns the sum of all elements in {@code cartItems}.
     * If the cart is empty, returns 0.0.
     */
    @Override
    public Double getCartSum() {
        return cart.getCartSum();
    }

    /**
     * Attempts to add an item to cart by {@code id}.
     * Returns true on success, and 404 Exception otherwise.
     */
    @Override
    public String addToCart(String id) {
        if (!cart.addToCart(id)) {
            throw new ItemNotFoundException(id);
        }
        itemHeap.add(itemsRepository.getItem(id));
        return "Successfully added " + id + " to cart!";
    }

    public Boolean isEmpty() {
        return itemHeap.size() == 0;
    }

    /**
     * Attempts to remove an item from the cart by {@code id}.
     * Returns success message upon successful removal, and throws {@code 404 Exception} otherwise.
     */
    @Override
    public String removeFromCart(String id) {
        if (!cart.removeFromCart(id)) {
            throw new ItemNotFoundException(id);
        }
        itemHeap.remove(itemsRepository.getItem(id));
        return "Successfully removed " + id + " from cart!";
    }

    /**
     * Retrieves the cheapest {@code Item} element from the cart.
     * Does so by maintaing a Min-Max heap for efficient retrievals.
     * If cart is empty, returns 404 exception instead.
     */
    @Override
    public Item getCheapestItem() {
        if (isEmpty()) {
            throw new ItemNotFoundException();
        }
        return itemHeap.peekFirst();
    }

    /**
     * Retrieves the priciest {@code Item} element from the cart.
     * Does so by maintaing a Min-Max heap for efficient retrievals.
     * If cart is empty, returns 404 exception instead.
     */
    @Override
    public Item getPriciestItem() {
        if (isEmpty()) {
            throw new ItemNotFoundException();
        }
        return itemHeap.peekLast();
    }
}
