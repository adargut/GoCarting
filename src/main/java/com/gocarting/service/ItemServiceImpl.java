package com.gocarting.service;

import com.gocarting.item.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;
import com.google.common.collect.MinMaxPriorityQueue;

@Service
public class ItemServiceImpl implements ItemService {

    // Keep track of how many different item we've created
    private int itemsAmount;

    // List of available products to put inside cart
    private HashMap<String, Item> itemMap;

    @SuppressWarnings("UnstableApiUsage")
    // Maintain a Min-Max Heap to retrieve both cheapest item and most expensive one
    private static MinMaxPriorityQueue<Item> itemHeap =
            MinMaxPriorityQueue.orderedBy(itemComparator).create();

    // No-Args ctr
    public ItemServiceImpl() {

        itemMap = new HashMap<>();

        final Item itemOne = new Item("10A", 15);
        final Item itemTwo = new Item("20B", 100);
        final Item itemThree = new Item("30C", 75.25);

        itemMap.put("10A", itemOne);
        itemMap.put("20B", itemTwo);
        itemMap.put("30C", itemThree);

        itemHeap.add(itemOne);
        itemHeap.add(itemTwo);
        itemHeap.add(itemThree);

        itemsAmount += 3;
    }

    /**
     * Returns a new Item instance by ID.
     */
    @Override
    public Item getItemByID(String id) {

        return itemMap.get(id);
    }

    /**
     * Searches for an item by ID.
     * Returns true is item is found, and false otherwise.
     */
    @Override
    public Boolean searchItemByID(String id) {

        if (itemMap.containsKey(id)) {
            return true;
        }
        return false;
    }

    /**
     * Returns the cheapest item by maintaining a Min-Max Heap for items.
     * This allows for optimal searches of least and greatest elements.
     */
    @Override
    public Item getCheapestItem() {

        return itemHeap.peekFirst();
    }

    /**
     * Returns the priciest item by maintaining a Min-Max Heap for items.
     * This allows for optimal searches of least and greatest elements.
     */
    @Override
    public Item getPriciestItem() {

        return itemHeap.peekLast();
    }
}
