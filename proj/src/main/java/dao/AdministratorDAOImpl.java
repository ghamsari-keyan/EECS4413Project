package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletContext;

import model.Administrator;

public class AdministratorDAOImpl implements AdministratorDAO {

	
	private ServletContext servletContext;
	
	
	public AdministratorDAOImpl(ServletContext servletContext) {
		
		this.servletContext = servletContext;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
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
	
	
	/**
	 * If we want to get a list of all the administrators
	 */
	public List<Administrator> getAllAdmin() {
		return null;
	}
	
	/**
	 * Add a new administrator
	 */
	public void newAdmin() {
		
	}
	
	/**
	 * remove an administrator
	 */
	public void removeAdmin() {
		
	}
	
	/**
	 * Update admin info given their unique adminId
	 */
	public void updateAdmin(int adminId) {
		
	}
	
	/*
	 * Check if the person trying to login is using valid credentials
	 */
	public int adminExists(String username, String password) {
		
		
		String usernameQuery = "SELECT * FROM computer_store.administrator where username='" + username + "'";
		String passwordQuery = "SELECT * FROM computer_store.administrator where password='" + password + "'";
		
		Connection con = null;
		
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(usernameQuery);
			
			if (res == null) {
				
				return 1;
			}
			
			res = stmt.executeQuery(passwordQuery);
			String userPass = res.getString(password);
			
			
			if (userPass.equals(password) == false) {
				
				return 2;
			}
			
			return 3;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
		}
		
		return 0;
	}
}
