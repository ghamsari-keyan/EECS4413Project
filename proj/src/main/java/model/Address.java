package model;

public class Address {

	private int addrId;
	private String street;
	private String province;
	private String country;
	private String postalCode;
	private String phoneNo;
	
	
	/*
	 * Address Constructor
	 */
	public Address(int addrId, String street, String province, String country, String postalCode, String phoneNo) {
		super();
		this.addrId = addrId;
		this.street = street;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		this.phoneNo = phoneNo;
	}
	/*
	 * get an set for all address attributes
	 */
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
