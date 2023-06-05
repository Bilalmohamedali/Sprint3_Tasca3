package controller;

import model.FlowerShop;
import model.Ticket;
import model.products.Decoration;
import model.products.Flower;
import model.products.Product;
import model.products.Tree;
import repository.Repository;
import view.Catalogue;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class FlowerShopController {
    private FlowerShop flowerShop;
    private Repository repository;

    public FlowerShopController(Repository repository){
        this.repository = repository;
    }

    public void createFlowerShop(){
        Scanner scanner = new Scanner(System.in);
        Catalogue.printCreateFlowersShopCatalogue();
        String name = scanner.nextLine();
        this.flowerShop = FlowerShop.getInstance(name);
        if (this.flowerShop != null){
            Catalogue.printFlowersShopCreated();
        }
    }

    public void createFlowerShop(String name){
        this.flowerShop = FlowerShop.getInstance(name);
        if (this.flowerShop != null){
            Catalogue.printFlowersShopCreated();
        }
    }

    public void addTree(){
        Scanner scanner = new Scanner(System.in);
        Catalogue.printAddTreeCatalogue();
        double height = scanner.nextDouble();
        Catalogue.printEnterPricePrompt();
        double price = scanner.nextDouble();
        this.flowerShop.addProduct(new Tree(price, height));
    }

    public void addFlower(){
        Scanner scanner = new Scanner(System.in);
        Catalogue.printAddFlowerCatalogue();
        String color = scanner.nextLine();
        Catalogue.printEnterPricePrompt();
        double price = scanner.nextDouble();
        this.flowerShop.addProduct(new Flower(price, color));
    }

    public void addDecoration(){
        Scanner scanner = new Scanner(System.in);
        Decoration.Material decorationMaterial = null;
        Catalogue.printAddDecorationCatalogue();
        String material = scanner.nextLine().toLowerCase();
        switch (material){
            case "plastico":
            case "plastic":
                decorationMaterial = Decoration.Material.Plastic;
                break;
            case "wood":
            case "madera":
                decorationMaterial = Decoration.Material.WOOD;
            default:
                System.out.println("Introduzca un material valido para el objeto");
        }
        Catalogue.printEnterPricePrompt();
        double price = scanner.nextDouble();
        this.flowerShop.addProduct(new Decoration(price, decorationMaterial));
    }

    public void showAllProducts(){
        this.flowerShop.showAllProduct();
    }

    public void removeTree(){
        Scanner scanner = new Scanner(System.in);
        Catalogue.printRemoveTreeCatalogue();
        this.flowerShop.showAllTrees();
        int productId = scanner.nextInt();
        this.flowerShop.removeProduct(this.flowerShop.findProduct(productId));
    }

    public void removeDecoration(){
        Scanner scanner = new Scanner(System.in);
        Catalogue.printRemoveDecorationCatalogue();
        this.flowerShop.showAllDecoration();
        int productId = scanner.nextInt();
        this.flowerShop.removeProduct(this.flowerShop.findProduct(productId));
    }

    public void removeFlower(){
        Scanner scanner = new Scanner(System.in);
        Catalogue.printRemoveFlowerCatalogue();
        this.flowerShop.showAllFlowers();
        int productId = scanner.nextInt();
        this.flowerShop.removeProduct(this.flowerShop.findProduct(productId));
    }

    public void showStockCategoryWithValues(){
        this.flowerShop.showAllProuctsByStockWithValues();
    }

    public void showStockTotalValue(){
        Catalogue.printTotalStockValue(this.flowerShop.getStockValue());
    }

    public void newPurchaseTicket(){
        Scanner scanner = new Scanner(System.in);
        Ticket newTicket = new Ticket();
        int option;
        Catalogue.printNewPurchaseTicketCatalogue();
        do {
            Catalogue.printAddProductsToPurchaseCatalogue();
            option = scanner.nextInt();
            switch (option){
                case 1:
                    Catalogue.printAvaliableDecorations();
                    addProductToTicketAndRemoveFromStock("Decoration", scanner, newTicket);
                    break;
                case 2:
                    Catalogue.printAvaliableFlowers();
                    addProductToTicketAndRemoveFromStock("Flower", scanner, newTicket);
                    break;
                case 3:
                    Catalogue.printAvaliableTrees();
                    addProductToTicketAndRemoveFromStock("Tree", scanner, newTicket);
                    break;
                case 0:
                    Catalogue.printTicketAddedCorrecly();
                    break;
                default:
                    System.out.println("Introduzca una opcion valida");
            }
        } while (option != 0);
        this.flowerShop.addTicket(newTicket);
    }

    private void addProductToTicketAndRemoveFromStock(Scanner scanner, Ticket newTikcet){
        showStockCategoryWithValues();
        System.out.println("Introduza el ID");
    }

    private void addProductToTicketAndRemoveFromStock(String category, Scanner scanner, Ticket newTicket){
        showStockByCategory(category);
        Catalogue.printEnterIdPrompt();
        int id = scanner.nextInt();
        Product product = getProductById(id);
        newTicket.addProduct(product);
        this.flowerShop.removeProduct(product);
        Catalogue.printProductAddedCorrecly();
    }

    private Product getProductById(int id) {
        return this.flowerShop.getProductById(id);
    }

    private void showStockByCategory(String category) {
        this.flowerShop.showStockByCategory(category);
    }
    public void showSalesHistory(){
        Catalogue.printSalesHistory(this.flowerShop.getSales());
    }

    public void showSalesTotalValue(){
        double value = 0;
        for (Ticket t : this.flowerShop.getSales()){
            value += t.getTotalPrice();
        }
    }

    public FlowerShop getFlowerShop(){
        return flowerShop;
    }

    public void saveFlowerShop(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            throw new RuntimeException(e);
        }
        JFrame frame = new JFrame("Guardar Catalogo");
        JFileChooser fileChooser = new JFileChooser();
        String filePath = "";
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();
            filePath = fileToSave.getAbsolutePath();
        }
        this.repository.saveFlowerShop(flowerShop, filePath);
    }

    public void loadFlowerShop(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            throw new RuntimeException(e);
        }
        JFrame frame = new JFrame("Cargar catalogo");
        JFileChooser fileChooser = new JFileChooser();
        String filePath = "";
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION){
            File fileToLoad = fileChooser.getSelectedFile();
            filePath = fileToLoad.getAbsolutePath();
        }
        this.flowerShop = this.repository.loadFlowerShop(filePath);
    }

}
