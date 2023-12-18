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
				Item product = new Item(res.getString("itemId"), res.getString("prodType"),
						res.getString("prodName"),res.getString("prodInfo"),
						res.getString("brand"),
						res.getInt("quantity"),
						res.getDouble("price"),
						res.getDouble("rating"),
						res.getBoolean("ecoFriendly"),
						res.getDouble("prodVersion"),
						res.getString("prodPlatform"),	
						res.getInt("weight"));

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
	public List<Item> getProductsByCategory(String prodType) {

		List<Item> resu = new ArrayList<Item>();

		String query = "SELECT * FROM computer_store.item WHERE prodType='" + prodType + "'";

		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				Item product = new Item(res.getString("itemId"), res.getString("prodType"),
						res.getString("prodName"),res.getString("prodInfo"),
						res.getString("brand"),
						res.getInt("quantity"),
						res.getDouble("price"),
						res.getDouble("rating"),
						res.getBoolean("ecoFriendly"),
						res.getDouble("prodVersion"),
						res.getString("prodPlatform"),	
						res.getInt("weight"));

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

	@Override
	public Item getProductById(String itemId) {
        String query = "SELECT * FROM item WHERE itemId ='" + itemId + "'";
        Item item = null;

        Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet resultSet = stmt.executeQuery(query);


            if (resultSet.next()) {
                // Replace these with the actual column names and types from your database
                System.out.println(resultSet.getString("prodName"));
            	String prodType = resultSet.getString("prodType");
                String prodName = resultSet.getString("prodName");
                String prodInfo = resultSet.getString("prodInfo");
                String brand = resultSet.getString("brand");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                double rating = resultSet.getDouble("rating");
                boolean ecoFriendly = resultSet.getBoolean("ecoFriendly");
                double prodVersion = resultSet.getDouble("prodVersion");
                String prodPlatform = resultSet.getString("prodPlatform");
                int weight = resultSet.getInt("weight");

                // Update the constructor call as per your Item class
                item = new Item(itemId, prodType, prodName, prodInfo, brand, quantity, price, rating, ecoFriendly, prodVersion, prodPlatform, weight);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions properly in production code
        }

        return item;
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
				Item product = new Item(res.getString("itemId"), res.getString("prodType"),
						res.getString("prodName"),res.getString("prodInfo"),
						res.getString("brand"),
						res.getInt("quantity"),
						res.getDouble("price"),
						res.getDouble("rating"),
						res.getBoolean("ecoFriendly"),
						res.getDouble("prodVersion"),
						res.getString("prodPlatform"),	
						res.getInt("weight"));
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

		String query = "SELECT DISTINCT BRAND FROM computer_store.item";

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

	@Override
	public List<String> getCategoryNames() {
		List<String> category = new ArrayList<String>();

		String query = "SELECT DISTINCT PRODTYPE FROM computer_store.item";

		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();

			ResultSet res = stmt.executeQuery(query);

			while(res.next()) {
				category.add(res.getString("prodType"));
			}



		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}

		return category;
	}
	
	
	public boolean addProductToDatabase(String id, String name, String category, String brand, 
	        String info, int qty, double price, double rating, boolean eco, double version, String platform,
	        int weight) {
	    
	    String checkQuery = "SELECT * FROM computer_store.item WHERE itemId = ?"; 
	    String addQuery = "INSERT INTO computer_store.item (itemId, prodType, prodName, prodInfo, brand, quantity, price, rating, ecoFriendly, prodVersion, prodPlatform, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection con = getConnection();
	         PreparedStatement checkStmt = con.prepareStatement(checkQuery);
	         PreparedStatement addStmt = con.prepareStatement(addQuery)) {

	        checkStmt.setString(1, id);
	        ResultSet rs = checkStmt.executeQuery();
	        
	        if (!rs.next()) {
	            addStmt.setString(1, id);
	            addStmt.setString(2, category);
	            addStmt.setString(3, name);
	            addStmt.setString(4, info);
	            addStmt.setString(5, brand);
	            addStmt.setInt(6, qty);
	            addStmt.setDouble(7, price);
	            addStmt.setDouble(8, rating);
	            addStmt.setBoolean(9, eco);
	            addStmt.setDouble(10, version);
	            addStmt.setString(11, platform);
	            addStmt.setInt(12, weight);

	            addStmt.executeUpdate();
	            return true;
	        } else {
	            return false;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Consider re-throwing the exception or handling it appropriately
	    }
	    return false;
	}


	@Override
	public List<Item> searchProducts(String keyword) {
		List<Item> searchResults = new ArrayList<>();
		String query = "SELECT * FROM item WHERE itemId LIKE ? OR prodName LIKE ? OR prodInfo LIKE ? OR brand LIKE ?";
		
        try (Connection con = getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            pstmt.setString(3, "%" + keyword + "%");
            pstmt.setString(4, "%" + keyword + "%");

            try (ResultSet res = pstmt.executeQuery()) {
                while (res.next()) {
                    Item product = new Item(res.getString("itemId"), res.getString("prodType"),
                            res.getString("prodName"), res.getString("prodInfo"), res.getString("brand"),
                            res.getInt("quantity"), res.getDouble("price"), res.getDouble("rating"),
                            res.getBoolean("ecoFriendly"), res.getDouble("prodVersion"),
                            res.getString("prodPlatform"), res.getInt("weight"));
                    searchResults.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

	

}
