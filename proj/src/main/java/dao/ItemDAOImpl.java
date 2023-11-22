package dao;
import java.util.*;

import model.Item;

public class ItemDAOImpl implements ItemDAO {


	/*
	 * Return a product inventory list
	 */
	public List<Item> productList() {
		
		return null;
	}
	
	/*
	 * returns a list of products given the type of product a user is looking for
	 */
	public List<Item> getProductsByCategory(String[] productTypes) {
		
		return null;
	}
	
	/*
	 * Return all products within a price range
	 */
	public List<Item> getProductsByPriceRange(int low, int high) {
		
		return null;
	}
	
	/*
	 * Get a list of products that have a certain ranking
	 */
	public List<Item> getProductsByRating(int rating) {
		
		return null;
	}
	
	
	/*
	 * Get a product by its id (for admin)
	 */
	public Item getProductById(int itemId) {
		
		return null;
	}
	
	
	/*
	 * Get a product by name (for customers via search)
	 */
	public Item getProductByName(String prodName) {
		
		return null;
	}
	
	/*
	 * Get a list of eco-friendly products
	 */
	public List<Item> getEcoFriendlyProducts() {
		
		
		return null;
	}
	
}
