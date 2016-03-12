//https://www.youtube.com/watch?v=25kUc_ammbw
//http://stackoverflow.com/questions/8059259/creating-a-console-menu-for-user-to-make-a-selection
//https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html

package oop_bookmart;
import java.util.Scanner;
import java.io.*;

public class LoginRegister {
	
	boolean exit;
	
	public void displayMenu()
	{
		
		while(!exit)
		{
			printMenu();
			int choice = getInput();
			userCase(choice);
		}
	}
	
	private void printMenu()
	{
		System.out.println("Welcome to BookMart");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Admin Login");
		System.out.println("0. Exit");
	}

	private int getInput()
	{
		Scanner selection = new Scanner(System.in);
		int choice = -9;

		while (choice < 0 || choice > 3)
		{
			System.out.print("Enter selection: ");
			System.out.print("");
			choice = Integer.parseInt(selection.nextLine());
		} 
		return choice;
	}
	
	private void userCase(int choice)
	{
		switch(choice)
		{
		case 0:
			exit = true;
			System.out.println("Exit\n");
			break;
			
		case 1:
			//user login
			//System.out.print("User Login\n");
			userLogin();
			break;
				
		case 2:
			//register
			System.out.print("New Registration\n");
			userRegister();
			break;
			
		case 3:
			//admin login
			//System.out.println("Admin Login\n");
			adminLogin();
			break;
		
		default:
			//Exit
			System.out.println("Exit program\n");
			break;
				
		}
	}
	
	public void userLogin()
	{
		boolean loginSuccess = false;
		//String line = null;
		String memberFile = "/home/jlcastaneda/Dropbox/workspace/oop_bookmart/src/oop_bookmart/Members.txt";
		Scanner userLogin = new Scanner(System.in);
		//System.out.println("User login method");
		System.out.print("Enter your email address: ");
		String checkEmail = userLogin.nextLine();
		System.out.print("\nEnter your password: ");
		String checkPasswd = userLogin.nextLine();
		
		System.out.println("Entered email: " + checkEmail + " password: " + checkPasswd);
		
		//Look for user in file
	    try {
	         // FileReader reads text files in the default encoding.
	         FileReader fileReader = 
	             new FileReader(memberFile);

	         // Always wrap FileReader in BufferedReader.
	         BufferedReader bufferedReader = 
	             new BufferedReader(fileReader);
	         
	         memberFile = bufferedReader.readLine();

	         while(memberFile != null) 
	         {
	             
	             String[] memberData = memberFile.split(", ");
	         
	             String userID = memberData[0];
	             String userFirst = memberData[1];
	             String userMiddle = memberData[2];
	             String userLast = memberData[3];
	             String userEmail = memberData[4];
	             String userPass = memberData[5];
	             String userStudent = memberData[6];
	             String userFaculty = memberData[7];
	             
	             //System.out.println("userID: " + userID);
	             //System.out.println("Saved email: " + userEmail);
	             //System.out.println("Saved password: " + userPass);
	             //System.out.println("Entered email: " + checkEmail);
	             //System.out.println("Entered password: " + checkPasswd);
	             
	             if(userEmail.equals(checkEmail))
	             {
	            	 System.out.println("User found");
	            	 if(userPass.equals(checkPasswd))
	            	 {
	            		 System.out.println("Password is good");
	            		 
	            	 }
	            	 loginSuccess = true;
	            	 //System.out.println("Login successful");
	            	 
	            	 //Create menu object
	            	 UserMenu menu = new UserMenu();
	            	 //Show user menu
	            	 menu.displayMenu();
	             }
	             //else System.out.println("User not found or password incorrect");
	             
		         if(loginSuccess == true)
		         {
		        	 System.out.println("User login successful");
		         }
		         else System.out.println("Login error");
	             
	             memberFile = bufferedReader.readLine();
	         
	         }   
	         //Close memberFile
	         bufferedReader.close();         
	     }
	     catch(FileNotFoundException ex) {
	         System.out.println(
	             "Unable to open file '" + 
	             memberFile + "'");                
	     }
	     catch(IOException ex) {
	          System.out.println(
	             "Error reading file '" 
	             + memberFile + "'");                  

	     }
	}
	
	public void userRegister()
	{
		System.out.println("User registration method");
	}
	
	public void adminLogin()
	{
		boolean loginSuccess = false;
		System.out.println("admin login method");
		//String line = null;
		String adminFile = "/home/jlcastaneda/Dropbox/workspace/oop_bookmart/src/oop_bookmart/AdminUsers.txt";
		Scanner userLogin = new Scanner(System.in);
		System.out.print("Enter your email address: ");
		String checkEmail = userLogin.nextLine();
		System.out.print("\nEnter your password: ");
		String checkPasswd = userLogin.nextLine();
		
		System.out.println("Entered email: " + checkEmail + " password: " + checkPasswd);
		
		//Look for user in file
	    try {
	         // FileReader reads text files in the default encoding.
	         FileReader fileReader = 
	             new FileReader(adminFile);

	         // Always wrap FileReader in BufferedReader.
	         BufferedReader bufferedReader = 
	             new BufferedReader(fileReader);
	         
	         adminFile = bufferedReader.readLine();

	         while(adminFile != null) 
	         {
	             loginSuccess = false;
	             String[] adminData = adminFile.split(", ");
	         
	             String adminID = adminData[0];
	             String adminFirst = adminData[1];
	             String adminMiddle = adminData[2];
	             String adminLast = adminData[3];
	             String adminEmail = adminData[4];
	             String adminPass = adminData[5];
	             //String adminStudent = memberData[6];
	             //String adminFaculty = memberData[7];
	             
	             //System.out.println("userID: " + userID);
	             //System.out.println("Saved email: " + userEmail);
	             //System.out.println("Saved password: " + userPass);
	             //System.out.println("Entered email: " + checkEmail);
	             //System.out.println("Entered password: " + checkPasswd);
	             
	             if(adminEmail.equals(checkEmail))
	             {
	            	 System.out.println("User found");
	            	 if(adminPass.equals(checkPasswd))
	            	 {
	            		 System.out.println("Password is good");
	            		 
	            	 }
	            	 //System.out.println("Login successful");
	            	 loginSuccess = true;
	            	 
	            	 //Create menu object
	            	 AdminMenu menu = new AdminMenu();
	            	 //Show user menu
	            	 menu.displayMenu();
	             }
	             //else System.out.println("Admin not found or password incorrect");
	             
	             adminFile = bufferedReader.readLine();	         
	         } 
	         
	         if(loginSuccess == true)
	         {
	        	 System.out.println("Admin login successful");
	         }
	         else System.out.println("Login error");
	         
	         //Close memberFile
	         bufferedReader.close();         
	     }
	     catch(FileNotFoundException ex) {
	         System.out.println(
	             "Unable to open file '" + 
	             adminFile + "'");                
	     }
	     catch(IOException ex) {
	          System.out.println(
	             "Error reading file '" 
	             + adminFile + "'");                  

	     }
	}
}