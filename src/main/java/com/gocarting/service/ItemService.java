package com.gocarting.service;

import com.gocarting.item.Item;

import java.util.Comparator;

public interface ItemService {

    // Compare products by their prices
    Comparator<Item> itemComparator = Comparator.comparing(Item::getPrice);

    Item getItemByID(final String id);

    Boolean searchItemByID(String id);
}
