package dao;

import java.util.*;

import model.Item;

public interface ItemDAO {

	 public List<Item> productList();
	 
	 public List<Item> getProductsByCategory(String[] productTypes);
	 
	 public List<Item> getProductsByPriceRange(int low, int high);
	 
	 public List<Item> getProductsByRating(int rating);
	 
	 public Item getProductById(int itemId);
	 
	 public Item getProductByName(String prodName);
	 
	 public List<Item> getEcoFriendlyProducts();
}
