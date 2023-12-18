package model;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private int addrId;
	private String street;
	private String province;
	private String country;
	private String postal;
	private String phone;
	
	/*
	 * Customer constructor
	 */
	public Customer(int id, String firstName, String lastName, int addrId, String street, String province, String country, String postal, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addrId = addrId;
		this.setStreet(street);
		this.setProvince(province);
		this.setCountry(country);
		this.setPostal(postal);
		this.setPhone(phone);
	}
	/*
	 * Customer get/set
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
