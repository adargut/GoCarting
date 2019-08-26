package com.gocarting.item;

public class Item {
    private String id;
    private double price;

    public Item(String id, double price) {
        this.price = price;
        // Ensure unique IDs are given to different item
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
}
