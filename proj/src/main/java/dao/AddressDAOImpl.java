package dao;
import java.util.List;

import model.Address;
public class AddressDAOImpl implements AddressDAO {

	
	public void setup() {
		// TODO Auto-generated method stub
		System.out.println("test");
	}

	
	/**
	 * This method returns all addresses on record
	 * Similar function to an address Book
	 */
	public List<Address> addressBook() {
		return null;
	}
	
	
	/**
	 * This method looks up all addresses on file for a customer given 
	 * the customers unique customer ID
	 */
	public List<Address> getAddressByCustId(int customerId) {
	
		return null;
	}
	
	/**
	 * If a customer wants to add an address to their account
	 * do so using this method
	 */
	public void addAddress(int customerId) {
		
	}
	
	/**
	 * Now, if a customer wants to remove a specific address from their record
	 * we will do it using their unique customer ID and the unique address ID
	 * Remember, customer has a 1:many relationship with address (i.e., one customer
	 * can have multiple addresses)
	 * 
	 * We also want to add a safety check so that a customer must have at least 1 address
	 * If the customer wants to remove their only address, we will redirect them to change 
	 * address method
	 */
	public void removeAddress(int customerId, int addrId) {
		
	}
	
	
	/**
	 * Cusomter can update their address info
	 */
	public void updateAddressById(int customerId, int addrId) {
		
	}
	
	/**
	 * Analytics tool can be used by admin
	 */
	public List<Address> getAddressByCountry() {
		
		return null;
	}
	
	
}
