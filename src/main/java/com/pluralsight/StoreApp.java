package com.pluralsight;
import java.io.*;
import java.util.*;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> products = loadInventory();
        displayInventory(products);
    }

    private static ArrayList<Product> loadInventory() {
        ArrayList<Product> products = getInventory();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                String Id = tokens[0];
                String name = tokens[1];
                Double price = Double.parseDouble(tokens[2]);
                Product product = new Product(Id, name, price);
                products.add(product);

        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return products;
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> products = new ArrayList<Product>();
        return products;
    }
    public static void displayInventory(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println(product.toCSV());
        }
    }
    public static void displaySort(ArrayList<Product> products) {
        Collections.sort(products, Comparator.comparing(Product::getName));

        for (Product product : products) {
            System.out.println(product.toCSV());
        }
        }
    }
}
