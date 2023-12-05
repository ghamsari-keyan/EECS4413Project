package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletContext;

import model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private ServletContext servletContext;
	
	
	public CustomerDAOImpl(ServletContext servletContext) {
		this.servletContext = servletContext;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // Handle the error appropriately
		}
	}
	
	/*
	 * Connection 
	 */
	private Connection getConnection() throws SQLException {
		String path = "jdbc:mysql://localhost:3306/computer_store";
		return DriverManager.getConnection(path, "root", "EECS4413");
	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	/*
	 * To retrieve a list of customer names
	 */
	public List<Customer> getCustomerList() {
		
		List<Customer> resu = new ArrayList<Customer>();
		
		String query = "SELECT * FROM computer_store.customer";
		
		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				Customer customer = new Customer(rs.getInt("id"), rs.getString("firstName"), 
						rs.getString("lastName"), rs.getInt("addressID"));
				
				resu.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
		}
		
		return resu;
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
