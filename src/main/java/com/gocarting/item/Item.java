package com.gocarting.item;

import java.util.Objects;

public class Item {
    private String id;
    private double price;

    public Item(String id, double price) {
        this.price = price;
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"itemId\":" + "\"" + id + "\"," +
                System.getProperty("line.separator") +
                " \"Price:\"'" + price + '\'' + '}';
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
