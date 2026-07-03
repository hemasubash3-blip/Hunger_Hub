package com.tap.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    // Add Item
    public void addItem(CartItem item) {

        int menuId = item.getMenuId();

        if (items.containsKey(menuId)) {

            CartItem existingItem = items.get(menuId);

            existingItem.setQuantity(
                    existingItem.getQuantity() + item.getQuantity());

        } else {

            items.put(menuId, item);
        }
    }

    // Update Quantity
    public void updateItem(int menuId, int quantity) {

        if (items.containsKey(menuId)) {

            if (quantity <= 0) {
                items.remove(menuId);
            } else {
                items.get(menuId).setQuantity(quantity);
            }
        }
    }

    // Remove Item
    public void removeItem(int menuId) {

        items.remove(menuId);
    }

    // Get All Items
    public Map<Integer, CartItem> getItems() {

        return items;
    }

    // Grand Total
    public double getGrandTotal() {

        double total = 0;

        for (CartItem item : items.values()) {

            total += item.getPrice() * item.getQuantity();
        }

        return total;
    }

    // Clear Cart
    public void clearCart() {

        items.clear();
    }

    // Check Empty
    public boolean isEmpty() {

        return items.isEmpty();
    }

    
    public double getTotalPrice() {

        double total = 0;

        for (CartItem item : items.values()) {
            total += item.getPrice() * item.getQuantity();
        }

        return total;
    }
}