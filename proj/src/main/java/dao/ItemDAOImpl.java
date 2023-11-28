package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletContext;

import model.Author;
import model.Book;
import model.Item;

public class ItemDAOImpl implements ItemDAO {

	private ServletContext servletContext;


	public ItemDAOImpl(ServletContext servletContext) {
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
	 * Return a product inventory list
	 */
	public List<Item> productList() {

		List<Item> resu = new ArrayList<Item>();

		String query = "SELECT * FROM computer_store.item";

		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				Item product = new Item();

				/*
				 * Retrieving all the information about a product 
				 */
				product.setItemId(res.getString("itemId"));
				product.setProdName(res.getString("prodName"));
				product.setProdVersion(res.getDouble("prodVersion"));
				product.setProdPlatform(res.getString("prodPlatform"));
				product.setProdType(res.getString("prodType"));
				product.setProdInfo(res.getString("prodInfo"));
				product.setBrandName(res.getString("brand"));
				product.setQuantityAvail(res.getInt("quantity"));
				product.setPrice(res.getDouble("price"));
				product.setRating(res.getDouble("rating"));
				product.setEcoFriendly(res.getBoolean("ecoFriendly"));
				product.setWeight(res.getInt("weight"));

				// now add the product to the list
				resu.add(product);

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
	 * returns a list of products given the type of product a user is looking for
	 */
	public List<Item> getProductsByCategory(String productTypes) {
		List<Item> resu = new ArrayList<Item>();

		String query = "SELECT * FROM computer_store.item";

		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				Item product = new Item();

				/*
				 * Retrieving all the information about a product 
				 */
				product.setItemId(res.getString("itemId"));
				product.setProdName(res.getString("prodName"));
				product.setProdVersion(res.getDouble("prodVersion"));
				product.setProdPlatform(res.getString("prodPlatform"));
				product.setProdType(res.getString("prodType"));
				product.setProdInfo(res.getString("prodInfo"));
				product.setBrandName(res.getString("brand"));
				product.setQuantityAvail(res.getInt("quantity"));
				product.setPrice(res.getDouble("price"));
				product.setRating(res.getDouble("rating"));
				product.setEcoFriendly(res.getBoolean("ecoFriendly"));
				product.setWeight(res.getInt("weight"));

				// now add the product to the list
				resu.add(product);

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
	 * Return all products within a price range
	 */
	public List<Item> getProductsByPriceRange(int low, int high) {

		return null;
	}

	/*
	 * Get a list of products that have a certain ranking
	 */
	public List<Item> getProductsByRating(int rating) {

		return null;
	}


	/*
	 * Get a product by its id (for admin)
	 */
	public Item getProductById(int itemId) {

		return null;
	}


	/*
	 * Get a product by name (for customers via search)
	 */
	public Item getProductByName(String prodName) {

		return null;
	}

	/*
	 * Get a list of eco-friendly products
	 */
	public List<Item> getEcoFriendlyProducts() {


		return null;
	}
	
	/*
	 * Returns the products of a certain Brand
	 */
	public List<Item> getProductsByBrand(String brand) {
		
		List<Item> resu = new ArrayList<Item>();

		String query = "SELECT * FROM computer_store.item WHERE brand='" + brand + "'";

		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				Item product = new Item();

				/*
				 * Retrieving all the information about a product 
				 */
				product.setItemId(res.getString("itemId"));
				product.setProdName(res.getString("prodName"));
				product.setProdVersion(res.getDouble("prodVersion"));
				product.setProdPlatform(res.getString("prodPlatform"));
				product.setProdType(res.getString("prodType"));
				product.setProdInfo(res.getString("prodInfo"));
				product.setBrandName(res.getString("brand"));
				product.setQuantityAvail(res.getInt("quantity"));
				product.setPrice(res.getDouble("price"));
				product.setRating(res.getDouble("rating"));
				product.setEcoFriendly(res.getBoolean("ecoFriendly"));
				product.setWeight(res.getInt("weight"));

				// now add the product to the list
				resu.add(product);

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
	
	
	public List<String> getBrandNames() {
		
		List<String> brands = new ArrayList<String>();
		
		String query = "SELECT DISTINCT BRAND FROM computer_store";

		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(query);
			
			while(res.next()) {
				brands.add(res.getString("brand"));
			}

			
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		
		return brands;
	}

}
