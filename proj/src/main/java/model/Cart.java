package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<Item> cart; // List of Items

    public Cart() {
        cart = new ArrayList<Item>();
    }
    
    public void addItem(Item item, int quantity) {
    	System.out.println("carttt");
    	System.out.println(getItems());
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        for (Item existingItem : cart) {
            if (existingItem.getItemId().equals(item.getItemId())) {
                existingItem.setOrderedQty(existingItem.getOrderedQty() + quantity);
                return;
            }
        }
        item.setOrderedQty(quantity);
        cart.add(item);
        
    }

    public void removeItem(String itemId) {
        Iterator<Item> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getItemId().equals(itemId)) {
                iterator.remove();
                break;
            }
        }
    }

    public void updateItem(String itemId, int quantity) {
        for (Item item : cart) {
            if (item.getItemId().equals(itemId)) {
                item.setOrderedQty(quantity);
                break;
            }
        }
    }
    

    public List<Item> getItems() {
        return cart;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : cart) {
            totalPrice += item.getPrice() * item.getOrderedQty();
        }
        return totalPrice;
    }

    public int size() {
        return cart.size();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public void clear() {
        cart.clear();
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : cart) {
            total += item.getPrice() * item.getOrderedQty();
        }
        return total;
    }
}
