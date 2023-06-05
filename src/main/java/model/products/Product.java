package model.products;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private static final long serrializableVersionUID = 1l;
    private double price;
    protected static int currentId = 0;
    private int id;

    public Product(double price) {
        this.price = price;
        currentId += 1;
        id = currentId;
    }

    public double getPrice() {
        return price;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public int getId() {
        return id;
    }
}
