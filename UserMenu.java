//https://www.youtube.com/watch?v=25kUc_ammbw
//http://stackoverflow.com/questions/8059259/creating-a-console-menu-for-user-to-make-a-selection


package oop_bookmart;
import java.util.Scanner;

public class UserMenu {
	int student;
	int staff;
	boolean exit;
	//Student Student1 = new Student();
	String uName;
	public void displayMenu(String uName, int student, int staff)
	{
		this.student = student;
		this.staff = staff;
		this.uName = uName;
		while(!exit)
		{
			printMenu();
			int choice = getInput();
			//System.out.println("Sending choice to case: " + choice);
			userCase(choice);
		}
	}
	
	private void printMenu()
	{
            System.out.println("User Menu");
            System.out.println("1. View User History");	
            System.out.println("2. Search by BookID");
            System.out.println("3. View book inventory");
            System.out.println("4. Browse by Category");
            System.out.println("5. Return a Book");
            System.out.println("6. Show Info");
            System.out.println("0. Exit");
	}

	private int getInput()
	{
		//System.out.println("getting input");
		Scanner selection = new Scanner(System.in);
		int choice = -9;
		//System.out.println("Entering while loop\n");
		while (choice < 0 || choice > 7)
		{
			//System.out.println("in while loop");
			System.out.print("Enter selection: ");
			System.out.print("");
			choice = Integer.parseInt(selection.nextLine());
		} //while (choice != 0);
		
		//System.out.println("\nchoice after while" + choice);
		//selection.close();
		return choice;
	}
	
	private void userCase(int choice)
	{
		//System.out.println("In case, choice: "+ choice);
		
		switch(choice)
		{
		case 0:
			exit = true;
			System.out.println("Exiting\n");
			break;
			
		case 1:
			//View user's history
			System.out.print("View user history\n");
			viewHistory();
			break;
				
		case 2:
			//Search user
			System.out.print("Search BookID\n");
			searchID();
			break;
			
		case 3:
			//View book inventory
			System.out.println("View book inventory\n");
			viewBookInv();
			break;
                        
                case 4:
                    //browse by category
                    System.out.println("Browse by category\n");
                    browseCat();
                    break;
			
		case 5:
			//return a book
			System.out.println("Return a book\n");
			returnBook();
			
		case 6:
			showStudent();
		
		default:
			//Exit
			System.out.println("Exit program\n");
			break;
				
		}
	}
	
	public void viewHistory()
	{
        History h = new History(uName);
        h.printHistory();
	}
	
	public void searchID()
	{
        BookInventory BI = new BookInventory(uName, student, staff);
        String b = null;
        BI.searchBookID(b);
        //BI.writeInventory();
	}
	
	public void viewBookInv()
	{
            BookInventory BI = new BookInventory(uName, student, staff);
            BI.printFullInventory();
	}
    public void browseCat(){
        BookInventory BI = new BookInventory(uName, student, staff);
        BI.browse();
            
    }
	
    public void returnBook(){
        //create a checked book object reading from file, 
        CheckedOut CO = new CheckedOut(uName, student, staff);
        String ID = CO.returnProcess();
        if(ID != "N"){
            BookInventory b = new BookInventory(uName, student, staff);
            b.returnBook(ID);
	//return book, overwrite file
        }
        else{
            System.out.println("You have no items to return.");
        }
           
		
	}
	
	public void showStudent()
	{
		//Student1.toString();
	}
}
