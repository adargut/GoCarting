package com.gocarting.item;

public interface ItemRepository {

    Item getItem(String id);

    Boolean hasItem(String id);
}
