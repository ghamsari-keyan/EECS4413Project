package dao;

import java.util.*;

import model.Item;

public interface ItemDAO {

	 public List<Item> productList();
	 	 
	 public List<Item> getProductsByPriceRange(int low, int high);
	 
	 public List<Item> getProductsByRating(int rating);
	 
	 public Item getProductById(int itemId);
	 
	 public Item getProductByName(String prodName);
	 
	 public List<Item> getEcoFriendlyProducts();
	 
	 public List<Item> getProductsByBrand(String brand);
	 
	 public List<Item> getProductsByCategory(String prodType);
	 
	 public List<String> getBrandNames();
	 
	 public List<String> getCategoryNames();
	 
	 public boolean addProductToDatabase(String id, String name, String category, String brand, 
				String info, int qty, double price, double rating, boolean eco, double version, String platform,
				int weight);

	public Item getProductById(String itemId);
	
    public List<Item> searchProducts(String keyword);


}
