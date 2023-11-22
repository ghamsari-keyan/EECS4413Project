package dao;

import java.util.List;

import model.Purchase;

public interface PurchaseDAO {

	public List<Purchase> purchaseHistory();
	
	public List<Purchase> getCustomerPurchaseHistory(int customerId);
	
	public List<Purchase> getProductPurchaseHistory(String prodId);
	
	public void newPurchase();
	
	public void updatePurchase();
	
	public Purchase getPurchaseById(int purchId);
	
	public List<Purchase> getPurchasesByDate(String date);
}
