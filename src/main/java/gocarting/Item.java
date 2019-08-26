package gocarting;

public class Item {
    private int id;
    private double price;

    public Item() {}

    public Item(int price) {
        this.price = price;
        // Ensure unique IDs are given to different items
        this.id = ItemData.genereateNewID();
    }

    public static Item getInstance(int id, int price) {
        return new Item(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"itemId\":" + "\"" + id + "\"," +
                System.getProperty("line.separator") +
                " \"Price:\"'" + price + '\'' + '}';
    }
}
