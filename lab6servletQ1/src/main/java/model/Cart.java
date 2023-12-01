package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
 
   private List<Book> cart;  // List of Books
 
   // constructor
   public Cart() {
      cart = new ArrayList<Book>();
   }
 
   // Add a Book into this Cart, with qtyOrdered. If the book of id already exists, update the qty ordered
   // if not, create a new book.
   public void add(int id, String title, String author, float price, int qtyOrdered) {
	   for (Book book : cart) {
           if (book.getId() == id) {
               // Update the quantity if the book already exists
               book.setOrderedQty(book.getOrderedQty() + qtyOrdered);
               return;
           }
       }
       // If the book does not exist, add a new book to the cart
	   Book newBook = new Book(id, author, title, price);
	   newBook.setOrderedQty(qtyOrdered);
       cart.add(newBook);
       
   }
 
   // Update the quantity for the given id, of total orderqty
   public void update(int id, int newQty) {
	   for (Book book : cart) {
           if (book.getId() == id) {
               // Update the quantity for the specified book
               book.setOrderedQty(newQty);
               return;
           }
       }
   }
 
   // Remove a Book given its id
   public void remove(int id) {
      Iterator<Book> iter = cart.iterator();
      while (iter.hasNext()) {
    	  if (iter.next().getId() == id) {
              iter.remove();
              return;
          }
      }
   }
 
   // Get the number of Books in this Cart
   public int size() {
      return cart.size();
   }
 
   // Check if this Cart is empty
   public boolean isEmpty() {
      return size() == 0;
   }
 
   // Return all the Books in a List<Book>
   public List<Book> getItems() {
      return cart;
   }
 
   // Remove all the items in this Cart
   public void clear() {
      cart.clear();
   }
}