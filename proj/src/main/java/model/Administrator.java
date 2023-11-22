package model;

public class Administrator {

	
	private int adminId;
	private String admFirstName;
	private String admLastName;
	private String admAddrId;
	
	/*
	 * admin constructor 
	 */
	public Administrator(int adminId, String admFirstName, String admLastName, String admAddrId) {
		super();
		this.adminId = adminId;
		this.admFirstName = admFirstName;
		this.admLastName = admLastName;
		this.admAddrId = admAddrId;
	}
	/*
	 * admin attributes get/set
	 */
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdmFirstName() {
		return admFirstName;
	}
	public void setAdmFirstName(String admFirstName) {
		this.admFirstName = admFirstName;
	}
	public String getAdmLastName() {
		return admLastName;
	}
	public void setAdmLastName(String admLastName) {
		this.admLastName = admLastName;
	}
	public String getAdmAddrId() {
		return admAddrId;
	}
	public void setAdmAddrId(String admAddrId) {
		this.admAddrId = admAddrId;
	}
	
	
}
