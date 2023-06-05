package model;

import model.products.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int currentId = 0;
    private final int id;
    private List<Product> products;
    private double totalPrice;

    public Ticket(){
        currentId += 1;
        this.id = currentId;
        this.totalPrice = 0;
        this.products = new ArrayList<>();
    }

    public Ticket(List<Product> products){
        currentId += 1;
        this.id = currentId;
        this.totalPrice = 0;
        this.products = products;
    }

    public void addProduct(Product product){
        this.products.add(product);
        updateTotalPrice();
    }

    public void removeProduct(Product product){
        this.products.remove(product);
        updateTotalPrice();
    }
    private void updateTotalPrice(){
        this.totalPrice = 0;
        this.products.forEach(product -> totalPrice += product.getPrice());
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("Ticket: ").append(id);
        stringBuilder.append("\n \n");
        this.products.forEach(product -> stringBuilder.append(product).append("\n"));
        stringBuilder.append("Total: ").append(totalPrice).append("€");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
