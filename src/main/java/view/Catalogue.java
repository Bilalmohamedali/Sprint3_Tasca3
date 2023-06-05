package view;

import model.Ticket;

import java.util.List;
import java.util.Scanner;

public class Catalogue {
    public static byte printCatalogue(){

        Scanner sc = new Scanner(System.in);
        byte option;
        final byte MIN = 0;
        final byte MAX = 14;

        do {
            System.out.println("     Catalogo    ");
            System.out.println();
            System.out.println("1 - Nuevo Pedido");
            System.out.println("2 - Añadir flor");
            System.out.println("3 - Añadir arbol");
            System.out.println("4 - Añadir decoracion");
            System.out.println("5 - Mostar catalogo");
            System.out.println("6 - Eliminar flor");
            System.out.println("7 - Eliminar arbol");
            System.out.println("8 - Eliminar decoracion");
            System.out.println("9 - Mostrar el catalogue por categoria");
            System.out.println("10 - Mostrar el valor total del stock");
            System.out.println("11 - Ticket");
            System.out.println("12 - Mostrar el historial de ventas");
            System.out.println("13 - Mostrar el valor de las ventas");
            System.out.println("14 - Cargar");
            System.out.println("0 - Guardar y salir");

            option = sc.nextByte();
            if (option < MIN || option > MAX){
                System.out.println("Opcion incorrecta");
            }
        }while (option < MIN || option > MAX);
        return option;
    }

    public static void printCreateFlowersShopCatalogue(){
        System.out.println(" Nuevo Pedido ");
        System.out.println("Introduce el nombre del pedido");
    }

    public static void printFlowersShopCreated(){
        System.out.println("Pedido creado!");
    }

    public static void printAddTreeCatalogue(){
        System.out.println(" Añadir arbol");
        System.out.println("Especifica la altura del arbol");
    }

    public static void printEnterPricePrompt(){
        System.out.println("Introduce el precio");
    }

    public static void printAddFlowerCatalogue(){
        System.out.println(" Añadir flor");
        System.out.println("Escoge el color");
    }

    public static void printAddDecorationCatalogue(){
        System.out.println(" Añadir decoracion");
        System.out.println("Escoge el material (madera/plastico");
    }

    public static void printNewPurchaseTicketCatalogue(){
        System.out.println(" Nueva compra");
    }

    public static void printAddProductsToPurchaseCatalogue(){
        System.out.println("1 - Añadir flor");
        System.out.println("2 - Añadir arbol");
        System.out.println("3 - Añadir decoracion");
        System.out.println("0 - Finalizar ticket");
        System.out.println("Introduzca una opcion");
    }

    public static void printTotalStockValue(double stockValue){
        System.out.println(" El valor total del stock es: " + stockValue + " ");
    }

    public static void printTotalPriceByStock(double value){
        System.out.println(" El valor del stock es: " + value + " ");
    }

    public static void printShowProductStock(String producClass){
        System.out.println(" Stock de " + producClass + " en tienda ");
    }

    public static void printRemoveTreeCatalogue(){
        System.out.println(" Eliminar arbol ");
        System.out.println("Introduce el id del arbol");
    }

    public static void printRemoveFlowerCatalogue(){
        System.out.println(" Eliminar flor");
        System.out.println(" Introduce el id de la flor");
    }

    public static void printRemoveDecorationCatalogue(){
        System.out.println(" Eliminar objeto decoracion");
        System.out.println(" Introduce el id del objeto");
    }

    public static void printAvaliableFlowers(){
        System.out.println(" Flores disponibles ");
    }
    public static void printAvaliableDecorations(){
        System.out.println("Objetos de decoracion disponible");
    }
    public static void printAvaliableTrees(){
        System.out.println("Arboles disponibles");
    }

    public static void printEnterIdPrompt(){
        System.out.println("Introduce el id del producto");
    }

    public static void printProductAddedCorrecly(){
        System.out.println("Se ha añadido un nuevo producto");
    }

    public static void printTicketAddedCorrecly(){
        System.out.println("Se ha creado un nuevo ticket");
    }

    public static void printSalesHistory(List<Ticket> sales){
        sales.forEach(System.out::println);
    }

    public static void printSalesTotalValue(Double value){
        System.out.println(" El calor total de las ventas ha sido: " + value + " ");
    }

}
