package dao;

import java.util.*;

import model.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomerList();
	
	public void newCustomer();
	
	public void removeCustomer(int customerId);
	
	public void updateCustomer(int customerId);
	
	public List<Customer> getCustomerByCountry(String[] countries);
	
	public void customerSpecialOffer(int customerId);
}
