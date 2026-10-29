# [Search Inventory]

[Command-line app that takes product data from a file that allows user to access through a menu.]

## Features

- [List all Products]
- [Lookup product by ID]
- [Lookup within a price range]

## How to run it

1. Clone the repository and open it in IntelliJ
2. Run `[StoreApp].java`
3. [Input number to pick from list of menu options]

## Screenshots

![The home screen](![img_1.png](img_1.png))

![App lists all products](![img.png](img.png))

## Interesting code

[Creating the method to look up a product by ID was a nice challenge to work on because
I had to think of a way to print an error only if it doesn't match at the end of the loop.]

```java
[public static void lookUpId(ArrayList<Product> products) {
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
}]
```

## Author

[JohnPaul Morris], Year Up Java Academy