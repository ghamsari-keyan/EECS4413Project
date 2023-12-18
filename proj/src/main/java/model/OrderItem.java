package model;

public class OrderItem {
	
	private int orderItemId;
	private int purchId;
	private String itemId;
	private int quantity;
	private double orderItemCost;
	
	/*
	 * OrderItem constructor
	 */
	public OrderItem(int orderItemId, int purchId, String itemId, int quantity, double orderItemCost) {
		super();
		this.orderItemId = orderItemId;
		this.purchId = purchId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.orderItemCost = orderItemCost;
	}
	
	/*
	 * orderItem get/set
	 */
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getPurchId() {
		return purchId;
	}
	public void setPurchId(int purchId) {
		this.purchId = purchId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getOrderItemCost() {
		return orderItemCost;
	}
	public void setOrderItemCost(double orderItemCost) {
		this.orderItemCost = orderItemCost;
	}
	
	

}
