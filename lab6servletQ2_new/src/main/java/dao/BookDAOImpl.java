package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import model.Author;
import model.Book;
import model.Category;

public class BookDAOImpl implements BookDAO {

	private ServletContext servletContext;

	public BookDAOImpl(ServletContext servletContext) {
		this.servletContext = servletContext; //servletContext should only work in servlets, so pass the servletContext from the servlet into this implementation
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	// complete this method
	private Connection getConnection() throws SQLException {
		String path = servletContext.getRealPath("/Books.db");
		return DriverManager.getConnection("jdbc:sqlite:" + path);
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

	// complete this method
	public List<Book> findAllBooks() {
		List<Book> result = new ArrayList<Book>();

		// join 3 tables to get needed info
		String sql = "SELECT b.id AS book_id, b.category_id, b.book_title, " +
				"a.id AS author_id, a.book_id AS author_book_id, a.first_name, a.last_name, " +
				"c.category_description " +
				"FROM book b " +
				"INNER JOIN author a ON b.id = a.book_id " +
				"INNER JOIN category c ON b.category_id = c.id";


		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				Author author = new Author();

				// populate book and author beans with needed info, and then set author to book
				book.setId(resultSet.getLong("book_id"));
				book.setCategoryId(resultSet.getLong("category_id"));
				book.setBookTitle(resultSet.getString("book_title"));

				author.setId(resultSet.getLong("author_id"));
				author.setBookId(resultSet.getLong("author_book_id"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("last_name"));

				book.setAuthor(author);
				book.setCategory(resultSet.getString("category_description"));

				result.add(book);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	// complete this method
	@Override
	public List<Book> searchBooksByKeyword(String keyWord) {
		List<Book> result = new ArrayList<Book>();

		String sql = "SELECT * FROM book INNER JOIN author ON book.id = author.book_id " +
				"INNER JOIN category ON book.category_id = category.id " +
				"WHERE book_title LIKE ? OR first_name LIKE ? OR last_name LIKE ?";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + keyWord.trim() + "%");
			statement.setString(2, "%" + keyWord.trim() + "%");
			statement.setString(3, "%" + keyWord.trim() + "%");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Book book = new Book();
				Author author = new Author();

				// populate book and author beans with needed info, and then set author to book
				book.setId(resultSet.getLong("id"));
				book.setCategoryId(resultSet.getLong("category_id"));
				book.setBookTitle(resultSet.getString("book_title"));

				author.setId(resultSet.getLong("id"));
				author.setBookId(resultSet.getLong("book_id"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("last_name"));

				book.setAuthor(author);
				book.setCategory(resultSet.getString("category_description"));

				result.add(book);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {  
			closeConnection(connection);
		}

		return result;
	}

	// complete this method
	public List<Category> findAllCategories() {
		List<Category> result = new ArrayList<>();
		String sql = "SELECT * FROM category";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();

				// populate category bean with needed info
				category.setId(resultSet.getLong("id"));
				category.setCategoryDescription(resultSet.getString("category_description"));

				result.add(category);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	public List<Book> findBooksByCategory(String category) {
		List<Book> result = new ArrayList<Book>();

		String sql = "SELECT * FROM book INNER JOIN author ON book.id = author.book_id " +
				"INNER JOIN category ON book.category_id = category.id " +
				"WHERE category_description = ?";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, category);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {

				Book book = new Book();
				Author author = new Author();

				// populate book and author beans with needed info, and then set author to book
				book.setId(resultSet.getLong("id"));
				book.setCategoryId(resultSet.getLong("category_id"));
				book.setBookTitle(resultSet.getString("book_title"));

				author.setId(resultSet.getLong("id"));
				author.setBookId(resultSet.getLong("book_id"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("last_name"));

				book.setAuthor(author);
				book.setCategory(resultSet.getString("category_description"));

				result.add(book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	public void insert(Book book) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO Book (category_id, book_title) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			statement.setLong(1, book.getCategoryId());
			statement.setString(2, book.getBookTitle());

			statement.execute();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				book.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public void delete(Long bookId) {
		Connection connection = null;

		try {
			connection = getConnection();
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM book WHERE id=?");
			statement.setLong(1, bookId);
			statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
}
