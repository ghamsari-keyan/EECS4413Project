package model;

public class Purchase {

	private int purchaseId;
	private int customerId;
	private int orderSize;
	private String date;
	

	/*
	 * Purchase Constructor
	 */
	public Purchase(int purchaseId, int customerId, int orderSize, String date) {
		super();
		this.purchaseId = purchaseId;
		this.customerId = customerId;
		this.orderSize = orderSize;
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

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getOrderSize() {
		return orderSize;
	}
	public void setOrderSize(int orderSize) {
		this.orderSize = orderSize;
	}

	
	
}
