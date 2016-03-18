/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_bookmart;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josh
 */
public class History {
    private List<Book> histItem = new ArrayList<>();
    //stores all book items that require history interaction
    String uName;
    
    public History(String uName){
        this.uName = uName;
    }
    
    public void checkOut(Book b){
        //check out function that completes required operations
        readHistory();
        histItem.add(b);
        writeHistory();        
    }
    
    public void printHistory(){
        histItem = new ArrayList<>();
        //prints the User's history
        //comment out or something
        readHistory();
        System.out.println("User's History: ");
        
        for(Book each: histItem){
            System.out.println(each);	
	}
    }
    
    
    
    public void readHistory(){
        
        //reads users history
        try{
            //create buff read with an instance of file read
            BufferedReader br = new BufferedReader(new FileReader(uName+"_History.txt"));
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
		histItem.add(tempObj);
	
		//read next line before looping
		//if end of file reached
		fileRead = br.readLine();
            }
            br.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println("User's history not found, creating new history file.");
            createHistory();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    
    public void createHistory(){
        //creates a new history file
        try {
            //Whatever the file path is.
            File statText = new File(uName+"_History.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write("");
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file Username_History.txt");
        }
    }
    
    public void writeHistory(){
        //writes the user's history
        try(Writer writer = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(uName+"_History.txt"), "utf-8")))){
            for(Book each: histItem){
		writer.write(each+"\n");                
            }
            writer.close();
        }
        catch(IOException ex){
            
        }
    }
}

