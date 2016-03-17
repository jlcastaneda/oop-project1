//https://www.youtube.com/watch?v=25kUc_ammbw
//http://stackoverflow.com/questions/8059259/creating-a-console-menu-for-user-to-make-a-selection


package oop_bookmart;
import java.util.Scanner;

public class AdminMenu {
	
	boolean exit;
	
	public void displayMenu()
	{
		
		while(!exit)
		{
			printMenu();
			int choice = getInput();
			//System.out.println("Sending choice to case: " + choice);
			adminCase(choice);
		}
	}
	
	private void printMenu()
	{
		System.out.println("\nAdmin Menu");
		System.out.println("1. View User's History");
		System.out.println("2. Search User");
		System.out.println("3. View book inventory");
		System.out.println("0. Exit");
	}

	private int getInput()
	{
		//System.out.println("getting input");
		Scanner selection = new Scanner(System.in);
		int choice = -9;
		//System.out.println("Entering while loop\n");
		while (choice < 0 || choice > 3)
		{
			//System.out.println("in while loop");
			System.out.print("Enter selection: ");
			choice = Integer.parseInt(selection.nextLine());
		} //while (choice != 0);
		
		//System.out.println("\nchoice after while" + choice);
		//selection.close();
		return choice;
	}
	
	private void adminCase(int choice)
	{
                Scanner s = new Scanner(System.in);
                String uName;
		//System.out.println("In case, choice: "+ choice);
		
		switch(choice)
		{
		case 0:
			exit = true;
			System.out.println("Exiting\n");
			break;
			
		case 1:
			//View user's history
			
                        System.out.print("View user's history\n");
                        System.out.print("Please enter a username: \n");
                        uName = s.next();
                        History h = new History(uName);
                        h.printHistory();
			break;
				
		case 2:
			//Search user
			System.out.print("search user\n");
			break;
			
		case 3:
			//View book inventory
			System.out.println("View book inventory\n");
                        BookInventory BI = new BookInventory("admin");
                        BI.printFullInventory();
			break;
		
		default:
			//Exit
			System.out.println("Exit program\n");
			break;
				
		}
	}
}
