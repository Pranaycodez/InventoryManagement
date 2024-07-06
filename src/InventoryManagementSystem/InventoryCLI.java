package InventoryManagementSystem;
import java.util.Scanner;
public class InventoryCLI {
    private static final Inventory inventory = new Inventory();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Quantity");
            System.out.println("3. Process Sale");
            System.out.println("4. View Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        updateQuantity();
                        break;
                    case 3:
                        processSale();
                        break;
                    case 4:
                        viewProducts();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InventoryException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred.");
            } finally {
                System.out.println("Operation completed.");
            }
        }
    }

    private static void addProduct() throws InventoryException {
        System.out.print("Enter product type (Electronics/Clothing): ");
        String type = scanner.nextLine();
        System.out.print("Enter product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = 0;
        while(true){
            try{
                String priceInput = scanner.nextLine();
                price = parsePrice(priceInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please enter a valid price in the format $10.99.");
            }
        }

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product;
        if (type.equalsIgnoreCase("Electronics")) {
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter warranty period (months): ");
            int warrantyPeriod = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            product = new Electronics(productID, productName, price, quantity, brand, warrantyPeriod);
        } else if (type.equalsIgnoreCase("Clothing")) {
            System.out.print("Enter size: ");
            String size = scanner.nextLine();
            System.out.print("Enter color: ");
            String color = scanner.nextLine();
            product = new Clothing(productID, productName, price, quantity, size, color);
        } else {
            throw new InventoryException("Invalid product type.");
        }

        inventory.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static double parsePrice(String priceInput) throws NumberFormatException {
        String priceString = priceInput.substring(1);
        return Double.parseDouble(priceString);
    }
    private static void updateQuantity() throws InventoryException {
        System.out.print("Enter product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        inventory.updateQuantity(productID, quantity);
        System.out.println("Quantity updated successfully.");
    }
    private static void processSale() throws InventoryException {
        System.out.print("Enter product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter quantity to sell: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        inventory.processSale(productID, quantity);
        System.out.println("Sale processed successfully.");
    }

    private static void viewProducts() {
        for (Product product : inventory.viewProducts()) {
            System.out.println(product);
        }
        if (inventory.viewProducts().isEmpty()) {
            System.out.println("No products in inventory.");
        }
    }
}
