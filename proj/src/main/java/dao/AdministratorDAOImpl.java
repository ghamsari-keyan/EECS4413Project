package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
}
