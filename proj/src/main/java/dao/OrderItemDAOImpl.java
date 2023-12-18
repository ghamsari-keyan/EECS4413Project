package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletContext;

import model.OrderItem;


public class OrderItemDAOImpl implements OrderItemDAO{

	private ServletContext servletContext;


	public OrderItemDAOImpl(ServletContext servletContext) {
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
	 * This class is used to get all order Items from a purchase
	 * This will be a list containing (possibly) multiple items
	 */
	public List<OrderItem> getItemsFromPurchaseId(int purchId) {
		
		List<OrderItem> resu = new ArrayList<OrderItem>();
		
		String query = "SELECT * FROM computer_store.orderItem WHERE purchId = '" + purchId + "'";
		
		Connection con = null;
		try {
			con = getConnection();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				OrderItem oi = new OrderItem(rs.getInt("orderItemId"), rs.getInt("purchId"), rs.getString("itemId"), rs.getInt("quantity"), rs.getDouble("orderItemCost"));
				resu.add(oi);
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
}
