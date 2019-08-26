package com.gocarting.item;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import com.google.common.collect.MinMaxPriorityQueue;

@Service
public class ItemRepository implements ItemHandler {

    private int itemsAmount;

    private HashMap<String, Item> itemMap;

    // TODO put this in cart
    @SuppressWarnings("UnstableApiUsage")
    private MinMaxPriorityQueue<Item> itemHeap =
            MinMaxPriorityQueue.orderedBy(itemComparator).create();

    public ItemRepository(HashMap<String, Item> itemMap) {

        itemMap = new HashMap<>() = itemMap;

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
