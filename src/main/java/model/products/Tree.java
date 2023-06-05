package model.products;

public class Tree extends Product{

    private double height;

    public Tree(double price, double height) {
        super(price);
        this.height = this.height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Tree: Strock ID: " + super.getId() + ", height: " + this.height + ",price:" + " " + this.getPrice() + " €";

    }
}
