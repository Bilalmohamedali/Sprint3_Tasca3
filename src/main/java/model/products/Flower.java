package model.products;

public class Flower extends Product {

    private String color;

    public Flower(double price, String color) {
        super(price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Flower: Strock ID: " + super.getId() + ", color: " + this.color + ",price:" + " " + this.getPrice() + " €";

    }
}
