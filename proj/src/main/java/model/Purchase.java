package model;

public class Purchase {

	private int purchaseId;
	private int customerId;
	private String itemId;
	private String date;
	

	/*
	 * Purchase Constructor
	 */
	public Purchase(int purchaseId, int customerId, String itemId, String date) {
		super();
		this.purchaseId = purchaseId;
		this.customerId = customerId;
		this.itemId = itemId;
		this.date = date;
	}
	/*
	 * Purchase get/set
	 */
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
