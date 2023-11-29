package dao;
import java.util.List;

import model.Administrator;


public interface AdministratorDAO {

	public List<Administrator> getAllAdmin();
	
	public void newAdmin();
	
	public void removeAdmin();
	
	public void updateAdmin(int adminId);
	
	public int adminExists(String username, String password);
}
