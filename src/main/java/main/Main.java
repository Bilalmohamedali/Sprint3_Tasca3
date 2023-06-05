package main;

import controller.FlowerShopController;
import repository.Repository;
import repository.TextFileRepository;
import view.Catalogue;

public class Main {
    public static void main(String[] args) {

        boolean exit = false;
        Repository repository = new TextFileRepository();
        FlowerShopController flowerShopController = new FlowerShopController(repository);

        do {
            switch (Catalogue.printCatalogue()){
                case 1:
                    flowerShopController.createFlowerShop();
                    break;
                case 2:
                    flowerShopController.addFlower();
                    break;
                case 3:
                    flowerShopController.addTree();
                    break;
                case 4:
                    flowerShopController.addDecoration();
                    break;
                case 5:
                    flowerShopController.showAllProducts();
                    break;
                case 6:
                    flowerShopController.removeTree();
                    break;
                case 7:
                    flowerShopController.removeDecoration();
                    break;
                case 8:
                    flowerShopController.removeFlower();
                    break;
                case 9:
                    flowerShopController.showStockCategoryWithValues();
                    break;
                case 10:
                    flowerShopController.showStockTotalValue();
                    break;
                case 11:
                    flowerShopController.newPurchaseTicket();
                    break;
                case 12:
                    flowerShopController.showSalesHistory();
                    break;
                case 13:
                    flowerShopController.showSalesTotalValue();
                    break;
                case 14:
                    flowerShopController.loadFlowerShop();
                    break;
                case 0:
                    System.out.println("Gracias por su compra");
                    flowerShopController.saveFlowerShop();
                    exit = true;
                    break;
            }
        }while (!exit);

    }
}
