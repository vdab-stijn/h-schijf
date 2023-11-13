package be.vdab.console;

import be.vdab.persistence.Order;
import be.vdab.persistence.Data;
import be.vdab.model.Product;
import be.vdab.persistence.OrderImpl;

import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        System.out.printf("Oplossing van %s %s\n",
        		System.getProperty("user.name"),
                "Java GOD");

        final Order order = new OrderImpl();
        final List<Product> list = Data.getData();

        for (Product artikel : list) {
            //order.voegProductToe(artikel);
        	order.addProduct(artikel);
        }

        System.out.println("lijst gesorteerd op natuurlijke volgorde: ");
        //order.sorteer();
        order.sort();

        System.out.println("\nlijst gesorteerd op merknaam: ");
        //order.sorteerOpMerk();
        order.sortByBrand();

        System.out.println("\nlijst gesorteerd op volume: ");
        //order.sorteerOpVolume();
        order.sortByVolume();

        System.out.println("\nVan het merk Georgio Armani:");
        //order.toonPerMerk("Georgio Armani");
        order.displayByBrand("Georgio Armani");

        System.out.println("\nAlle Parfums:");
        //order.toonParfums();
        order.displayPerfumes();

        System.out.println("\nAlle producten onder € 50; ");
        //order.toonGoedkopeProducten();
        order.displayCheapestProducts();

        //Product product = order.zoekDuursteProduct();
        final Product product = order.findMostExpensiveProduct();
        System.out.println("\nDuurste product:\n" + product);

        //System.out.printf("\nTotale prijs: â‚¬%.2f", order.totalePrijs());
        System.out.printf("\nTotale prijs: € %.2f", order.totalPrice());
    }
}
