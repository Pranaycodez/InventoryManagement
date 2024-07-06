package InventoryManagementSystem;

public class Electronics extends Product {
    private String brand;
    private int warrantyPeriod; // in months

    public Electronics(String productID, String productName, double price, int quantity, String brand, int warrantyPeriod) {
        super(productID, productName, price, quantity);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    // Additional methods specific to Electronics

}
