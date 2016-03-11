//from left to right 
//book id, isbn, amount in inventory, publish date, publish company, category
//research sources
//https://www.reddit.com/r/javaexamples/comments/344kch/reading_and_parsing_data_from_a_file/
//http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventorySystem{

}

public void readInventory(){
	//create array list
	ArrayListList<Inventory> invItem = new ArrayList<>();
	//create buff read with an instance of file read
	BufferedReader br = new BufferedReader(new FileReader("BookInventory.txt"));
	//read line
	String fileRead = br.readLine();
	while(fileRead != null){
		//use string.split to load a string array with the values from each line
		//of the file using a comma as a delimiter
		String[] tempHold = fileRead.split(",");
	
		//assume file is made correctly
		//and make temporary variables for the types of data
		String tempId = tempHold[0];	//book id
		String tempIsbn = tempHold[1];	//isbn
		int tempInv = Integer.parseInt(tempHold[3]);	//amount in inventory
		String tempTitle = tempHold[4];	//title
		String tempAuthor = tempHold[5];	//author
		String tempDate = tempHold[6];	//date of publishing
		String tempPub = tempHold[7];	//publishers name
		String tempCat = tempHold[8];	//category
	
		//create temporary instance of Inventory Object
		//and load with data values
		Inventory tempObj = new Inventory(tempId, tempIsbn, tempInv, tempTitle, tempAuthor, tempDate, 
			tempPub, tempCat);
	
		//add to array List
		invItem.add(tempObj);
	
		//read next line before looping
		//if end of file reached
		fileRead = br.readLin();
	}
	br.close();
}

public void printInventory(){
	for (Inventory each: invItem){
		System.out.println(each)	
	}
}

public void writeInventory(){
	Writer writer = new BufferedWriter(new OutputStreamWriter)(new FileOutputStream("BookInventory.txt"), "utf-8"));
	for(Inventory each: invItem){
		writer.write(each+",");
	}
}