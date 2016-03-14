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
		System.out.println("\nWelcome to BookMart");
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
			System.out.print("User Login\n");
			userLogin();
			break;
				
		case 2:
			//register
			System.out.print("New Registration\n");
			userRegister();
			break;
			
		case 3:
			//admin login
			System.out.println("Admin Login\n");
			adminLogin();
			break;
		
		default:
			//Exit
			System.out.println("Exit program\n");
			break;
				
		}
	}
	
	public boolean userLogin()
	{
		boolean loginSuccess = false;
		boolean isStudent = false;
		boolean isFaculty = false;
		int LogUserID = 0;
		//String memberFile = "/home/jlcastaneda/Dropbox/workspace/oop_bookmart/src/oop_bookmart/Members.txt";
		String memberFile = "src/oop_bookmart/Members.txt";
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
	             String userPaypalID = memberData[8];
	             
	             LogUserID = Integer.parseInt(userID);
	             isStudent = Boolean.parseBoolean(userStudent);
	             isFaculty = Boolean.parseBoolean(userFaculty);
	             //System.out.println("userID: " + userID);
	             //System.out.println("Saved email: " + userEmail);
	             //System.out.println("Saved password: " + userPass);
	             //System.out.println("Entered email: " + checkEmail);
	             //System.out.println("Entered password: " + checkPasswd);
	             System.out.println("Student value: " + userStudent);
	             System.out.println("Faculty value: " + userFaculty);
	             System.out.println("isStudent value: " + isStudent);
	             System.out.println("isFaculty value: " + isFaculty);
	                      
	             if(userEmail.equals(checkEmail))
	             {
	            	 System.out.println("User found");
	            	 if(userPass.equals(checkPasswd))
	            	 {
	            		 System.out.println("Password is good");         		 
	            	 }
	            	 loginSuccess = true;
	            	 System.out.println("Login successful");
	            	 
	            	 //Create student user object
	            	 if(isStudent == true)
	            	 {
	            		 Student Student1 = new Student(LogUserID, userFirst, userMiddle, userLast, 
	            				 userEmail, userPass, isStudent, isFaculty, userPaypalID);
	            		 
	            		 System.out.println(Student1.toString());
	            	  
	            		 //Create menu object	            	 
	            		 UserMenu menu = new UserMenu();
	            		 //Show user menu
	            		 menu.displayMenu();
	            	 }
	            	 else
	            	 {
	            		 Faculty Faculty1 = new Faculty(LogUserID, userFirst, userMiddle, userLast, 
	            				 userEmail, userPass, isStudent, isFaculty, userPaypalID);
	            		 
	            		 System.out.println(Faculty1.toString());
	            	  
	            		 //Create menu object	            	 
	            		 UserMenu menu = new UserMenu();
	            		 //menu.showStudent();
	            		 menu.displayMenu();
	            	 }
	      
	            
	             }
	             //else System.out.println("User not found or password incorrect");
	             memberFile = bufferedReader.readLine();       
	         }   
	         
	         if(!loginSuccess == true)
	        	 System.out.println("User login error\n");
	         
	         //Close memberFile
	         bufferedReader.close();         
	     }
	     catch(FileNotFoundException ex) {
	         System.out.println("Unable to open file '" + memberFile + "'");                
	     }
	     catch(IOException ex) {
	          System.out.println("Error reading file '"+ memberFile + "'");                  

	     }
	    return loginSuccess;
	}
	
	public boolean userRegister()
	{
		boolean registerSuccess = false;
		Scanner userData = new Scanner(System.in);
		int nextUserID = getNextID();
		String firstName = null;
		String middleIni = null;
		String lastName = null;
		String emailAddr = null;
		String password1 = null;
		String password2 = null;
		String paypalID = null;
		int memberType = 0;
		boolean student = false;
		boolean faculty = false;
		boolean userExists = false;
		String memberFile = "src/oop_bookmart/Members.txt";
		System.out.println("New user ID = " + nextUserID);
		
		System.out.print("Enter email address: ");
		emailAddr = userData.nextLine();
		userExists = checkUserExists(emailAddr);
		
		while(userExists == true)
		{
			System.out.print("'"+ emailAddr +"' is already registered, try another: ");
			emailAddr = userData.nextLine();
			userExists = checkUserExists(emailAddr);
		}
		
		//Ask user for information
		System.out.print("Enter first name: ");
		firstName = userData.nextLine();
		System.out.print("Enter middle initial, N for none: ");
		middleIni = userData.nextLine();
		System.out.print("Enter last name: " );
		lastName = userData.nextLine();
		System.out.print("Enter password: ");
		password1 = userData.nextLine();
		System.out.print("Verify password: ");
		password2 = userData.nextLine();
		System.out.print("Enter PayPal ID: ");
		paypalID = userData.nextLine();
		
		while(!password1.equals(password2))
		{
			System.out.println("Passwords do not match, try again:");
			System.out.print("Enter password: ");
			password1 = userData.nextLine();
			System.out.print("Verify password: ");
			password2 = userData.nextLine();
		}
		
		System.out.print("Enter 1 for student, 2 for faculty: ");
		memberType = Integer.parseInt(userData.nextLine());
		
		while(memberType < 1 || memberType > 2)
		{
			System.out.print("Please enter 1 for student, 2 for faculty: ");
			memberType = Integer.parseInt(userData.nextLine());
		}
		
		if (memberType == 1) student = true;
		else faculty = true;
		
		System.out.println("First name: " + firstName);
		System.out.println("Middle Initial: " + middleIni);
		System.out.println("Last name: " + lastName);
		System.out.println("Email address: "+ emailAddr);
		System.out.println("Password: " + password1);
		System.out.println("Student: " + student);
		System.out.println("Faculty: " + faculty);
		System.out.println("PaypalID: " + paypalID);
		
		//Write user data into Members.txt file
		try
		{
			FileWriter newUser = new FileWriter(memberFile, true);
			Writer enterUser = new BufferedWriter(newUser);
			
			enterUser.write(nextUserID +", "+ firstName +", "+ middleIni +", "+ lastName +", "+
			emailAddr +", "+ password1 +", "+ student +", "+ faculty + ", " + paypalID + "\n");
			
			System.out.println("New user for " + firstName + " " + middleIni + " " +
					lastName + " created successfully");
			
			
			enterUser.close();
	} catch (Exception e)
		{
			System.out.println("Cannot write to file");
		}
		
		return registerSuccess;		
	}
	
	public boolean adminLogin()
	{
		boolean loginSuccess = false;
		int logUserID = 0;
		//System.out.println("admin login method");
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
	         FileReader fileReader = new FileReader(adminFile);

	         // Always wrap FileReader in BufferedReader.
	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         
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
	             logUserID = Integer.parseInt(adminID);
	             
	             if(adminEmail.equals(checkEmail))
	             {
	            	 System.out.println("User found");
	            	 if(adminPass.equals(checkPasswd))
	            	 {
	            		 System.out.println("Password is valid");
	            		 
	            	 }
	            	 loginSuccess = true; //Set to true if user enters valid info
	            	 
	            	 //Create admin object
	            	 Admin Admin1 = new Admin(logUserID, adminFirst, adminMiddle, adminLast,
	            			 adminEmail, adminPass);
	            	 
	            	 System.out.println(Admin1.toString());
	            	 
	            	 //Create menu object
	            	 AdminMenu menu = new AdminMenu();
	            	 //Show user menu
	            	 menu.displayMenu();
	             } 
	             adminFile = bufferedReader.readLine();	         
	         } 
	         
	         if(!loginSuccess == true)
	        	 System.out.println("Admin login error");
	         
	         //Close memberFile
	         bufferedReader.close();         
	     }
	     catch(FileNotFoundException ex) {
	         System.out.println("Unable to open file '" + adminFile + "'");                
	     }
	     catch(IOException ex) {
	          System.out.println("Error reading file '" + adminFile + "'");                  

	     }
	    return loginSuccess;
	}
	
	public int getNextID()
	{
		String userFile = "/home/jlcastaneda/Dropbox/workspace/oop_bookmart/src/oop_bookmart/Members.txt";
		
		//Determine available userID number
		int nextID = 0;
		
		try {
	         // FileReader reads text files in the default encoding.
	         FileReader fileReader = new FileReader(userFile);

	         // Always wrap FileReader in BufferedReader.
	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         
	         //Read the user file
	         userFile = bufferedReader.readLine();

	         while(userFile != null) 
	         {
	             String[] userID = userFile.split(", ");	         
	             String availableID = userID[0];
	             nextID = Integer.parseInt(availableID) + 1; 
	             userFile = bufferedReader.readLine();	         
	         }
		bufferedReader.close();
		
		}
	    catch(FileNotFoundException ex) {
		    System.out.println("Unable to open file '" + userFile + "'");                
		}
		catch(IOException ex) {
		     System.out.println("Error reading file '" + userFile + "'");                  

		}
		return nextID;
	}
	
	public boolean checkUserExists(String newEmail)
	{
		String userFile = "/home/jlcastaneda/Dropbox/workspace/oop_bookmart/src/oop_bookmart/Members.txt";
		
		//Determine available userID number
		boolean userExists = false;
		
		try {
	         // FileReader reads text files in the default encoding.
	         FileReader fileReader = new FileReader(userFile);

	         // Always wrap FileReader in BufferedReader.
	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         
	         //Read the user file
	         userFile = bufferedReader.readLine();

	         while(userFile != null) 
	         {
	             String[] userEmail = userFile.split(", ");	         
	             String emailRegistered = userEmail[4];
	             
	             //Check if email address is already registered
	             if(emailRegistered.equals(newEmail))
	            	 userExists = true;
	             
	             userFile = bufferedReader.readLine();	         
	         }
		bufferedReader.close();
		
		}
	    catch(FileNotFoundException ex) {
		    System.out.println("Unable to open file '" + userFile + "'");                
		}
		catch(IOException ex) {
		     System.out.println("Error reading file '" + userFile + "'");                  

		}
		return userExists;
	}
	
}