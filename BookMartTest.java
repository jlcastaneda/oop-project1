//Main class for testing
package oop_bookmart;

import java.lang.reflect.Method;
import java.util.Scanner;

public class BookMartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Testing admin, student and faculty object creation
		//Admin Admin1 = new Admin(0, "Admin", "N", "None", "admin@bookmart.com", "Admin1234");
		//Student Student1 = new Student(501, "Klark", "S", "Kent", "superklark@bookmart.com", "superPass");
		//Faculty Faculty1 = new Faculty(502, "Druce", "B", "Wayne", "darknight@bookmart.com", "darkPass");
		
		//System.out.println(Admin1.toString());
		//System.out.println(Student1.toString());
		//System.out.println(Faculty1.toString());

		//Determine whether admin or user is logged in and run appropriate menu
		//Testing admin menu
		//AdminMenu menu = new AdminMenu();	
		//menu.displayMenu();
	
		//Testing user menu
		UserMenu userMenu = new UserMenu();
		userMenu.displayMenu();
		
	}
}