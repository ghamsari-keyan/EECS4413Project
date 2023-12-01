package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;

public class BookBAOImpl implements BookDAO{
	
	public ArrayList<Book> search (String names[]) {
		ArrayList<Book> output = new ArrayList<>();
		try {
	    	            
           String query = "select * from books where author = '" + names[0]+"'";
           
           for(int i=1; i < names.length; i++) {
           	query += " OR author = '" + names[i]+"'";
           }
           
           query += ";";
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/lab6";
           String user = "root";
           String password = "EECS4413";
           Connection connection = DriverManager.getConnection(url, user, password);
           java.sql.Statement stmt = connection.createStatement();
           
           ResultSet resultSet=stmt.executeQuery(query);
           
           while (resultSet.next()) {
               int id = resultSet.getInt("id");
               String title = resultSet.getString("title");
               String author = resultSet.getString("author");
               float price = resultSet.getFloat("price");

               Book book = new Book(id, title, author, price);
               output.add(book);
           }
          
        
           
       }catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }
		
		return output;
	    	
	}
	
	 public Book searchByID(int bookid) {
		 Book book = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/lab6";
	            String user = "root";
	            String password = "EECS4413";

	            try (Connection connection = DriverManager.getConnection(url, user, password)) {
	                String query = "SELECT * FROM books WHERE id = ?";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                    preparedStatement.setInt(1, bookid);

	                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                        if (resultSet.next()) {
	                            int id = resultSet.getInt("id");
	                            String title = resultSet.getString("title");
	                            String author = resultSet.getString("author");
	                            float price = resultSet.getFloat("price");

	                            book = new Book(id, title, author, price);
	                        }
	                    }
	                }
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return book;

    }

}
