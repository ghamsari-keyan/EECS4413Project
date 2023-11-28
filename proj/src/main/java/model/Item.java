package model;

public class Item {

	private String itemId;
	private String prodType;
	private String prodName;
	private String prodInfo;
	private String brandName;
	private int quantityAvail;
	private double price;
	private double rating;
	private boolean ecoFriendly;
	private double prodVersion;
	private String prodPlatform;
	private int weight;
	

	/*
	 * Getter and Setter Methods for attributes
	 */
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdInfo() {
		return prodInfo;
	}
	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getQuantityAvail() {
		return quantityAvail;
	}
	public void setQuantityAvail(int quantityAvail) {
		this.quantityAvail = quantityAvail;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isEcoFriendly() {
		return ecoFriendly;
	}
	public void setEcoFriendly(boolean ecoFriendly) {
		this.ecoFriendly = ecoFriendly;
	}
	public double getProdVersion() {
		return prodVersion;
	}
	public void setProdVersion(double prodVersion) {
		this.prodVersion = prodVersion;
	}
	public String getProdPlatform() {
		return prodPlatform;
	}
	public void setProdPlatform(String prodPlatform) {
		this.prodPlatform = prodPlatform;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
