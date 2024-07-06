package InventoryManagementSystem;
import java.util.Scanner;

public class Product {
    protected String productID;
    protected String productName;
    protected double price;
    protected int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return price * quantity;
    }

    // Getters and setters for each attribute
    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
}
