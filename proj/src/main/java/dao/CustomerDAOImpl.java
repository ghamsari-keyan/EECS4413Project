package dao;

import java.util.*;

import model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	
	/*
	 * To retrieve a list of customer names
	 */
	public List<Customer> getCustomerList() {
		return null;
	}
	
	/*
	 * Use to add a customer to the database
	 */
	public void newCustomer() {
		
	}
	
	/*
	 * Remove a customer from the database
	 */
	public void removeCustomer(int customerId) {
		
	}
	
	/*
	 * update customer information 
	 */
	public void updateCustomer(int customerId) {
		
	}
	
	/*
	 * To get a list of customers by country
	 * 
	 * Could be useful when checking for regional discounts 
	 * (i.e., Canadian customers get 50% off in December)
	 */
	public List<Customer> getCustomerByCountry(String[] countries) {
		
		return null;
		
	}
	
	/*
	 * get any possible customer discounts
	 */
	public void customerSpecialOffer(int customerId) {
		
	}
	
}
