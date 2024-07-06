package InventoryManagementSystem;

public class Clothing extends Product {
    private String size;
    private String material;

    public Clothing(String productID, String productName, double price, int quantity, String size, String material) {
        super(productID, productName, price, quantity);
        this.size = size;
        this.material = material;
    }

}
