package InventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) throws InventoryException {
        if (product.getQuantity() < 0) {
            throw new InventoryException("Quantity cannot be negative.");
        }
        if (product.getPrice()<0){
            throw new InventoryException("Price cannot be negative");
        }
        products.add(product);
    }

    public void updateQuantity(String productID, int quantity) throws InventoryException {
        for (Product product : products) {
            if (product.getProductID().equals(productID)) {
                if (quantity < 0) {
                    throw new InventoryException("Quantity cannot be negative.");
                }
                product.setQuantity(quantity);
                return;
            }
        }
        throw new InventoryException("Product not found.");
    }

    public void processSale(String productID, int quantity) throws InventoryException {
        for (Product product : products) {
            if (product.getProductID().equals(productID)) {
                if (quantity > product.getQuantity()) {
                    throw new InventoryException("Insufficient stock.");
                }
                product.setQuantity(product.getQuantity() - quantity);
                return;
            }
        }
        throw new InventoryException("Product not found.");
    }

    public List<Product> viewProducts() {
        return products;
    }
}

