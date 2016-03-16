/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproj1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Reader;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class BookInventory {
    //create array list
    public List<Book> invItem = new ArrayList<>();  //list of objects   
    Scanner s = new Scanner(System.in); //scanner for input
    String uName;   //username
    
    
    public BookInventory(String uName){
        this.uName = uName;
    }
    
    public void readInventory(){    //reads inventory from file

        try{
            //create buff read with an instance of file read
            BufferedReader br = new BufferedReader(new FileReader("BookInventory.txt"));
            //read line
            String fileRead = br.readLine();
            while(fileRead != null){
		//use string.split to load a string array with the values from each line
		//of the file using a comma as a delimiter
		String[] tempHold = fileRead.split(", ");
	
		//assume file is made correctly
		//and make temporary variables for the types of data
		String tempId = tempHold[0];	//book id
		String tempIsbn = tempHold[1];	//isbn
		int tempInv = Integer.parseInt(tempHold[2]);	//amount in inventory
		String tempTitle = tempHold[3];	//title
		String tempAuthor = tempHold[4];	//author
		String tempDate = tempHold[5];	//date of publishing
		String tempPub = tempHold[6];	//publishers name
		String tempCat = tempHold[7];	//category
	
		//create temporary instance of Inventory Object
		//and load with data values
		Book tempObj = new Book(tempId, tempIsbn, tempInv, tempTitle, tempAuthor, tempDate, tempPub, tempCat);
	
		//add to array List
		invItem.add(tempObj);
	
		//read next line before looping
		//if end of file reached
		fileRead = br.readLine();
            }
            br.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println("file not found");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void printFullInventory(){   //prints the full inventory
        int x = 0;
	for(Book each: invItem){
            System.out.println(x+": ");
            System.out.println(each);	
            x++;
	}
    }
    public void writeInventory(){        //writes inventory to a file
	try(Writer writer = new BufferedWriter((new OutputStreamWriter(new FileOutputStream("BookInventory.txt"), "utf-8")))){
            
            for(Book each: invItem){
		writer.write(each+"\n");
                
            }
            writer.close();
        }
        catch(IOException ex){
            
        }
    }
    
    
    
    
    
    public void printCatInventory(int h, int l){
        int item;
        System.out.println("Category: "+invItem.get(l).category);   //prints book in category
	for(int x = l; x <= h; x++){

            System.out.println(x+": "+invItem.get(x));	
	}
        int choice;
        System.out.println("Check out an item?");   //checks out item
        System.out.println("1: Yes      2: No");
        choice = s.nextInt();
        if(choice == 1){
            do{
                System.out.println("Input the item number: ");
                item = s.nextInt();
                if(item < l || item > h){
                    System.out.println("Item number not valid, attempt again.");
                }
            }while(item < l || item > h);
            //checkout
            checkOut(item);
        }
        else{
            System.out.println("Returning to menu.");
        }
    }
    
    public void browse(){
        readInventory();    //reads inventory
        int choice = 0; //selection
        int high;   //high range
        int low;    //low range
        System.out.println("Please select a category: ");
        System.out.println("1: Art");
        System.out.println("2: Business & Economics");
        System.out.println("3: Computer Science");
        System.out.println("4: Design");
        System.out.println("5: Education");
        System.out.println("6: Law");
        System.out.println("7: Mathematics");
        System.out.println("8: Music");
        System.out.println("9: Philosophy & Psychology");
        choice = s.nextInt();
        high = (choice * 5) - 1;    //calc's high value
        low = high - 4; //calcs low value
        printCatInventory(high, low);   //prints books in those ranges
    }
    
    
    
    
    
    //searches inventory based off of Book ID
    public void searchBookID(){
        readInventory();    //reads inventory
        Scanner s = new Scanner(System.in);
        String bID = null;
        int found = 0;
        int count = 0;
        int y;
        System.out.println("1. Search for item");   //menu
        System.out.println("2. Exit");
        y = s.nextInt();    //selection
        while(y == 1){
            
            System.out.println("Please enter a book ID: ");
            bID = s.nextLine(); //gives book id
            for(Book each: invItem){    //searches through each item in the list
                if(bID.equals(invItem.get(count).bID)){
                    found = 1;
                }
                else{
                    count++;
                }
            }
            if(found == 1){ //if found
                //print item
            
                int x = 0;
                System.out.println("Item Found: "+invItem.get(count));  //print book info
                if(invItem.get(count).invAmnt > 0){
                    System.out.println("Check out this item?"); //asks if they want to check out book
                    System.out.println("1: Yes      2: No");
                    x = s.nextInt();
                    if(x == 1){
                        //check out process
                        checkOut(count);
                    }
                    else{
                        System.out.println("Moving back to menu."); 
                    }
                }
                else{
                    System.out.println("Sorry, this item is currently unavailable. Moving to menu.");
                }
            }
            else{
                System.out.println("Item not found with entered ID, moving to menu.");
            }
            System.out.println("1. Search For Item");
            System.out.println("2. Exit Menu");
        }
    }
    
    
    public void checkOut(int invNum){
        //Inventory controller       
        //most operations require the username of the user                
        //get inventory and print                                              
        History h = new History(uName);                        
        //checkoutprocess
        invItem.get(invNum).checkOut();
        h.checkOut(invItem.get(invNum));        
        //Writes Inventory
        writeInventory();      
        System.out.println("Check out complete, inventory modified, user history updated.");
        System.out.println("Date and Time of checkout: ");
        System.out.println("Date and Time of return: ");
        System.out.println("Returning to menu.");
        //print the user's History
    }
    
    
    
    
    
}
