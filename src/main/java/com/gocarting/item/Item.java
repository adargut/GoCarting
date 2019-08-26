package com.gocarting.item;

public class Item {
    private String id;
    private double price;

    // Full-Args ctr
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
}
