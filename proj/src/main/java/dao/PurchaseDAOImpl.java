package dao;

import java.util.List;

import model.Purchase;

public class PurchaseDAOImpl implements PurchaseDAO{

	/*
	 * Get a list of all purchases (for admin)
	 */
	public List<Purchase> purchaseHistory() {
		
		return null;
	}
	
	/*
	 * get purchase history of a customer
	 */
	public List<Purchase> getCustomerPurchaseHistory(int customerId) {
		
		return null;
	}
	
	/*
	 * get all purchases of a specific product
	 */
	public List<Purchase> getProductPurchaseHistory(String prodId) {
		
		return null;
	}
	
	/*
	 * create a new purchase/order
	 */
	public void newPurchase() {
		
	}
	
	/*
	 * update a purchase (i.e., change purchase info)
	 */
	public void updatePurchase() {
		
	}
	
	/*
	 * get purchase information by Id (can be used for purchase tracking by customer)
	 */
	public Purchase getPurchaseById(int purchId) {
		
		return null;
	}
	
	/*
	 * get a list of all purchases on a date
	 */
	public List<Purchase> getPurchasesByDate(String date) {
		
		return null;
	}
	
}
