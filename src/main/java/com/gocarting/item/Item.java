package com.gocarting.item;

import java.util.Objects;

public class Item implements Comparable<Item> {

    private String itemId;
    private double price;

    public Item(String itemId, double Price) {
        this.price = Price;
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public String getItemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId.equals(item.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public int compareTo(Item item) {
        return Double.compare(this.price, item.price);
    }

    @Override
    public String toString() {
        return "{" +
                "\"itemId\": " + "\"" + itemId + "\"," +
                System.lineSeparator() +
                " \"Price\": " + price + "}";
    }
}
