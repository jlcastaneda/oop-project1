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

/**
 *
 * @author Josh
 */
public class BookInventory {
    //create array list
    public List<Book> invItem = new ArrayList<>();
    
    public void readInventory(){

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
    public void printInventory(){
	for(Book each: invItem){
		System.out.println(each);	
	}
    }
    public void writeInventory(){
        
	try(Writer writer = new BufferedWriter((new OutputStreamWriter(new FileOutputStream("BookInventory.txt"), "utf-8")))){
            
            for(Book each: invItem){
		writer.write(each+",");
            }
        }
        catch(IOException ex){
            
        }
    }
    
}
