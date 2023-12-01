package dao;

import java.util.ArrayList;
import model.*;

public interface BookDAO {
	
	public ArrayList<Book> search (String names[]);
	
	public Book searchByID(int id);

}
