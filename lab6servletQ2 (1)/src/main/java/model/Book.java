package model;

import java.util.List;

public class Book {
	private Long id;
	private Long categoryId;
	private String bookTitle;
	private List<Author> authors;
	private Author author;
	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	public String toString() {
		return "Book - Id: " + id + ", Book Title: " + bookTitle;
	}

	public void setAuthor(Author author) {
		this.author = author;
		// TODO Auto-generated method stub
		
	}

	public void setCategory(String long1) {
		// TODO Auto-generated method stub
		this.category = long1;
		
	}

	public Author getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

}
