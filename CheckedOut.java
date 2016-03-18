//check out class

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_bookmart;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class CheckedOut {
    private List<Book> checkedItem = new ArrayList<>();
    //stores all book items that require history interaction
    String uName;
    int student;
    int staff;
    int amnt;
    
    public CheckedOut(String uName, int student, int staff){
        this.uName = uName;
	this.student = student;
	this.staff = staff;
        if(student == 1){
            amnt = 1;
        }
        if(staff == 1){
            amnt = 4;
        }
		
    }
    
    public String returnProcess(){
        Scanner s = new Scanner(System.in);
        String ID = null;
        int x;
        int y;
        printChecked();
        if(countChecked() != 0){
            System.out.println("Return an Item?");
            System.out.println("1. Yes      2. No");
            x = s.nextInt();
            if(x == 1){
                System.out.println("Please enter the item number you wish to return.");
                y = s.nextInt();
                if(y >= 0 || y <= countChecked()){
                    ID = checkedItem.get(y).bID;
                    checkedItem.remove(checkedItem.get(y));
                    writeChecked();
                    return ID;
                }
                System.out.println("Invalid input.");            
            }
        }
        return("N");
    }
    
    
    public void checkOut(Book b){
        //check out function that completes required operations
        readChecked();
        checkedItem.add(b);
        writeChecked();        
    }
    
    public int countChecked(){
        checkedItem = new ArrayList<>();
        readChecked();
        int x = 0;
        for(Book each: checkedItem){
            x++;
        }
        return x;
    }
    
    
    public void printChecked(){
        checkedItem = new ArrayList<>();
        //prints the User's history
        //comment out or something
        readChecked();
        System.out.println("User's Checked Out Books: ");
        int x = 0;
        for(Book each: checkedItem){
            System.out.println(x+": "+each);
            x++;
	}
    }

    public void readChecked(){
        
        //reads users history
        try{
            //create buff read with an instance of file read
            BufferedReader br = new BufferedReader(new FileReader(uName+"_Checked.txt"));
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
		checkedItem.add(tempObj);
	
		//read next line before looping
		//if end of file reached
		fileRead = br.readLine();
            }
            br.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println("User's check out file not found, creating new check out file.");
            createChecked();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    
    public void createChecked(){
        //creates a new history file
        try {
            //Whatever the file path is.
            File statText = new File(uName+"_Checked.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write("");
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file Username_History.txt");
        }
    }
    
    public void writeChecked(){
        //writes the user's history
        try(Writer writer = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(uName+"_Checked.txt"), "utf-8")))){
            for(Book each: checkedItem){
		writer.write(each+"\n");                
            }
            writer.close();
        }
        catch(IOException ex){
            
        }
    }
}