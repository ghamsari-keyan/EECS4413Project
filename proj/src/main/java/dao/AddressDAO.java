package dao;

import java.util.List;

import model.Address;
public interface AddressDAO {
	public void setup();
	
	/**
	 * TO IMPLEMENT:
	 * 
	 * ALL METHODS FOR CREATING, FETCHING, MODIFYING, DELETING DATABSE ITEMS
	 */
	
	public List<Address> addressBook();
	
	public List<Address> getAddressByCustId(int customerId);
	
	public void addAddress(int customerId);
	
	public void removeAddress(int customerId, int addrId);
	
	public void updateAddressById(int customerId, int addrId);
	
	public List<Address> getAddressByCountry();
}
