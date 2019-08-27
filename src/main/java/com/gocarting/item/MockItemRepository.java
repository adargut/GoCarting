package com.gocarting.item;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Mock repository for items.
 */
public class MockItemRepository implements ItemRepository {

    private int itemsAmount;

    private final Map<String, Item> items  = new HashMap<String, Item>() {{
        put("10A", new Item("10A", 150));
        put("20B", new Item("20B", 200));
        put("30C", new Item("30C", 65.5));
        put("40D", new Item("40D", 10.25));
        put("50E", new Item("50E", 3.145159));
        put("60F", new Item("60F", 79));
        put("70G", new Item("70G", 42.4242));
        put("80H", new Item("80H", 1241));
        put("90I", new Item("90I", 196));
    }};

    /**
     * Returns a new Item instance by {@code id}.
     */
    public Item getItem(String id) {
        return items.get(id);
    }

    /**
     * Searches for an item by {@code id}.
     * Returns true is item is found, and false otherwise.
     */
    public Boolean hasItem(String id) {
        return (items.containsKey(id));
    }
}
