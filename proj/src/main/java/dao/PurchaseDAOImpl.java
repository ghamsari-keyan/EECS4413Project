package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import model.Item;
import model.Purchase;

public class PurchaseDAOImpl implements PurchaseDAO{
	
	private ServletContext servletContext;

	public PurchaseDAOImpl(ServletContext servletContext) {
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
	 * Get a list of all purchases (for admin)
	 */
	public List<Purchase> purchaseHistory() {
		
		List<Purchase> resu = new ArrayList<Purchase>();

		String query = "SELECT * FROM computer_store.purchaseOrder ORDER BY date DESC";

		Connection con = null;
		
		try {
			
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				Purchase purchase = new Purchase(rs.getInt("purchId"), rs.getInt("customerId"), rs.getInt("quantity"), rs.getString("date"));
				resu.add(purchase);
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
	 * get purchase history of a customer
	 */
	public List<Purchase> getCustomerPurchaseHistory(int customerId) {
		
		return null;
	}
	
	/*
	 * get all purchases of a specific product
	 */
	public List<Purchase> getProductPurchaseHistory(String prodId) {
		
		return null;
	}
	
	/*
	 * create a new purchase/order
	 */
	public void newPurchase() {
		
	}
	
	/*
	 * update a purchase (i.e., change purchase info)
	 */
	public void updatePurchase() {
		
	}
	
	/*
	 * get purchase information by Id (can be used for purchase tracking by customer)
	 */
	public Purchase getPurchaseById(int purchId) {
		
		return null;
	}
	
	/*
	 * get a list of all purchases on a date
	 */
	public List<Purchase> getPurchasesByDate(String date) {
		
		return null;
	}
	
}
