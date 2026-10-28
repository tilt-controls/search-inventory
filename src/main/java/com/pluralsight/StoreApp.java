package com.pluralsight;

import java.io.*;
import java.util.*;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> products = loadInventory();
        menu(products);
    }

    private static ArrayList<Product> loadInventory() {
        ArrayList<Product> products = getInventory();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
            String line;

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
        }
        return products;
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

    public static void lookUpId(ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        boolean productFound = false;
        System.out.println("Enter product Id here: ");
        String inputId = scanner.nextLine().trim();

        for (Product product : products) {
            if (inputId.equalsIgnoreCase(product.getId())) {
                System.out.println(product.toCSV());
                productFound = true;
                break;
            }
        } if (!productFound) {
            System.out.println("Sorry but " + inputId + " does not match our inventory");
        }
    }

    public static void menu(ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        while (active) {
            System.out.println("    ===INVENTORY MENU===");
            System.out.println("""
                       What would you like to do?\n
                       1- List all products
                       2- Lookup a product by its Id
                       3- Find all products within a price range
                       4- Add a new product
                       5- Quit the application\n
                    Enter the command:""");

            int command = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (command) {
                case 1:
                    System.out.println("ID|NAME|PRICE");
                    displaySort(products);
                    System.out.println();
                    break;
                case 2:
                    lookUpId(products);
                    System.out.println();
                    break;
            }
        }
    }

}
