package model;

import model.products.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlowerShop implements Serializable {
    private static final long serialVersionUID = 1L;
    private static FlowerShop instance;
    private String name;
    private Stock stock;
    private List<Ticket> sales;

    public FlowerShop(String name) {
        this.name = name;
        this.stock = new Stock();
        this.sales = new ArrayList<>();
    }

    public static FlowerShop getInstance(String name) {
        if (instance == null ){
            instance = new FlowerShop(name);
        }
        return instance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Floristeria: ").append(name).append("\n");
        sb.append("Valor stock: ").append(stock.getTotalStockValue()).append("€\n");
        for (Ticket ticket : sales) {
            sb.append(ticket.toString()).append("\n");
        }
        sb.append("\n");
        sb.append("Productos en stock: ").append(stock.getAllProductsStock().size()).append("\n");
        return sb.toString();
    }
    public void addProduct(Product product){
        this.stock.addProduct(product);
    }
    public void removeProduct(Product product){
        this.stock.removeProduct(product);
    }
    public double getStockValue(){
        return this.stock.getTotalStockValue();
    }
    public void showAllProduct(){
        this.stock.printAllProducts();
    }
    public Product getProductById(int id) {
        return this.stock.getProductById(id);
    }
    public void addTicket(Ticket newTicket){
        this.sales.add(newTicket);
    }
    public void showAllProuctsByStockWithValues(){
        this.stock.printAllProductsByStockWithValues();
    }

    public String getName() {
        return name;
    }

    public Stock getStock() {
        return stock;
    }

    public void showAllTrees(){
        this.stock.printTrees();
    }
    public void showAllFlowers(){
        this.stock.printFlowers();
    }
    public void showAllDecoration(){
        this.stock.printDecoration();
    }
    public Product findProduct(int productId){
        return this.stock.findProduct(productId);
    }

    public List<Ticket> getSales() {
        return sales;
    }

    public void setSales(List<Ticket> sales) {
        this.sales = sales;
    }

    public void showStockByCategory(String category){
        this.stock.showStockByCategory(category);
    }
    public void showSalesHistory(){
        this.sales.forEach(System.out::println);
    }
    public double showTotalSalesValue(){
        double totalSalesValue = 0;
        for (Ticket ticket : sales){
            totalSalesValue += ticket.getTotalPrice();
        }
        return totalSalesValue;
    }
}
