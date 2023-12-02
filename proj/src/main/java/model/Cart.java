package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
	
	 private List<Item> cart;  // List of Books
	 
	   // constructor
	   public Cart() {
	      cart = new ArrayList<Item>();
	   }
	 
	   // Add a Item into this cartServlet, with qtyOrdered. If the item of id already exists, update the qty ordered
	   // if not, create a new item.
	   public void add(String itemId, String prodType, String prodName, String prodInfo, String brandName,int quantityAvail,
		double price,
		double rating,
		boolean ecoFriendly,
		double prodVersion,
		String prodPlatform,
		int weight,
		int qtyOrdered) {
		   for (Item item : cart) {
	           if (item.getItemId().equals(itemId)) {
	               // Update the quantity if the item already exists
	               item.setOrderedQty(item.getOrderedQty() + qtyOrdered);
	               return;
	           }
	       }
	       // If the item does not exist, add a new book to the cart
		   Item newItem = new Item(itemId, prodType,prodName, prodInfo, brandName, quantityAvail,
		 price,
		 rating,
		 ecoFriendly,
		 prodVersion,
		 prodPlatform,
		 weight);
		   newItem.setOrderedQty(qtyOrdered);
	       cart.add(newItem);
	       
	   }
	 
	   // Update the quantity for the given id, of total orderqty
	   public void update(String itemId, int newQty) {
		   for (Item item : cart) {
	           if (item.getItemId().equals(itemId)) {
	               // Update the quantity for the specified book
	               item.setOrderedQty(newQty);
	               return;
	           }
	       }
	   }
	 
	   // Remove a item given its id
	   public void remove(String itemId) {
	      Iterator<Item> iter = cart.iterator();
	      while (iter.hasNext()) {
	    	  if (iter.next().getItemId().equals(itemId)) {
	              iter.remove();
	              return;
	          }
	      }
	   }
	 
	   // Get the number of item in this cartServlet
	   public int size() {
	      return cart.size();
	   }
	 
	   // Check if this cartServlet is empty
	   public boolean isEmpty() {
		    return cart.isEmpty();
		}
	 
	   // Return all the item in a List<Item>
	   public List<Item> getItems() {
	      return cart;
	   }
	 
	   // Remove all the items in this cartServlet
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
