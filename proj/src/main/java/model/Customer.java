package model;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private int addrId;
	
	/*
	 * Customer constructor
	 */
	public Customer(int id, String firstName, String lastName, int addrId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addrId = addrId;
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
	
	
	
}
