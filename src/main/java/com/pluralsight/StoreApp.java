package com.pluralsight;
import java.util.*;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        inventory.add(new Product("10", "Apple", 1.99));
        inventory.add(new Product("11", "Banana", 0.99));
        inventory.add(new Product("12", "Cantaloupe", 2.99));
        inventory.add(new Product("13", "Orange", 1.49));
        inventory.add(new Product("14", "Mango", 3.99));

        
    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        return inventory;

    }
}
