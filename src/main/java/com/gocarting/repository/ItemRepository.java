package com.gocarting.repository;

import com.gocarting.item.Item;

public interface ItemRepository {

    Item getItem(String id);

    Boolean hasItem(String id);
}
