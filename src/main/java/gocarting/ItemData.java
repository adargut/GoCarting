package gocarting;

import java.util.HashMap;
import java.util.Comparator;
import com.google.common.collect.MinMaxPriorityQueue;
import gocarting.StatusHandler.BadRequestException;

public class ItemData {
    // Keep track of how many different items we've created
    private static int itemsAmount = 1;

    // List of available products to put inside cart
    private static HashMap<String, Item> items = new HashMap<>();

    // Sort products by their prices
    private static Comparator<Item> itemComparator = Comparator.comparing(Item::getPrice);

    // Maintain a Min-Max Heap to retrieve both cheapest item and most expensive one
    private static MinMaxPriorityQueue<Item> itemHeap =
                   MinMaxPriorityQueue.orderedBy(itemComparator).create();

    /**
     *
     * Allows searching for an item by its unique Id.
     * }</pre>
     *
     */
    static Item searchByItemID(String itemId) {
        if (items.containsKey(itemId)) {
            return items.get(itemId);
        }
        return null;
    }

    /**
     * Returns the cheapest item available
     * <pre>{@code
     *
     * }</pre>
     *
     */
    static Item getCheapest() {
        return itemHeap.peekFirst();
    }

    /**
     * Returns the priciest item available
     * <pre>{@code
     *
     * }</pre>
     *
     */
    static Item getPriciest() {
        return itemHeap.peekLast();
    }

    static int genereateNewID() {
        itemsAmount++;
        return itemsAmount;
    }

    private static ItemData instance = null;
    public static ItemData getInstance(){
        if(instance == null){
            instance = new ItemData();
        }
        return instance;
    }

}
