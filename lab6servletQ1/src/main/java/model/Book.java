package model;
public class Book {
	int id;
	String author;
	String Title;
	float price;
	int orderedQty;
	
	public Book(int id, String author, String title, float price) {
		super();
		this.id = id;
		this.author = author;
		Title = title;
		this.price = price;
		this.orderedQty = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getOrderedQty() {
        return orderedQty;
    }

    public void setOrderedQty(int orderedQty) {
        this.orderedQty = orderedQty;
    }
    
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", Title=" + Title + ", price=" + price + "]";
	}
	
	
	

}
