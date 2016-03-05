package oop_bookmart;

public class Admin {
	
	private int adminID;
	private String adminFName;
	private String adminMidIni;
	private String adminLName;
	private String adminEmail;
	private String adminPasswd;
	
	//Constructor to create administrator with parameters
	public Admin(int adminID, String adminFName, String adminMidIni, 
			String adminLName, String adminEmail, String adminPasswd)
	{
		this.adminID = adminID;
		this.adminFName = adminFName;
		this.adminMidIni = adminMidIni;
		this.adminLName = adminLName;
		this.adminEmail = adminEmail;
		this.adminPasswd = adminPasswd;
	}
	
	//Set the admin id number
	public void setAdminID(int adminID) 
	{
		if(adminID == 0)
			this.adminID = adminID + 1;
	}
	
	//Set the admin first name
	public void setAdminFName(String adminFName) 
	{
		if(adminFName == "Admin")
			this.adminFName = adminFName + "1"; 
	}
	
	//Set the admin middle initial
	public void setAdminMidIni(String adminMidIni) { this.adminMidIni = adminMidIni; }
	
	//Set the admin last name
	public void setAdminLName(String adminLName) { this.adminLName = adminLName; }
	
	//Set the admin email address
	public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }
	
	//set the admin password
	public void setAdminPasswd(String adminPasswd) { this.adminPasswd = adminPasswd; }
	
	//Get the admin ID
	public int getAdminID() { return adminID; }
	
	//Get the admin first name
	public String getAdminFName() { return adminFName; }
	
	//Get the admin middle initial
	public String getAdminMidIni() { return adminMidIni; }
		
	//Get the admin last name
	public String getAdminLName() { return adminLName; }
	
	//Get the admin email address
	public String getAdminEmail() { return adminEmail; }
	
	//Get the admin password
	public String getAdminPasswd() { return adminPasswd; }
	
	//Get admin data
	@Override
	public String toString()
	{
		return "Admin data: \n" + "Admin ID: " + adminID + "\nFirst Name: " + adminFName + 
				"\nMiddle Ini: " + adminMidIni + "\nLast Name: " + adminLName + 
				"\nEmail address: " + adminEmail + "\n";
	}
	

}
