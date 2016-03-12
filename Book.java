/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproj1;

/**
 *
 * @author Josh
 */
public class Book {
    public String bID;
    public String ISBN;
    public int invAmnt;
    public String title;
    public String author;
    public String pDate;
    public String pub;
    public String category;
    
    
    
    
    
    
    
    public Book(String tempId, String tempIsbn, int tempInv, String tempTitle, String tempAuthor, String tempDate, String tempPub, String tempCat){
        bID = tempId;
        ISBN = tempIsbn;
        invAmnt = tempInv;
        title = tempTitle;
        author = tempAuthor;
        pDate = tempDate;
        pub = tempPub;
        category = tempCat;
    }
    
    public void checkOut(){
        if(invAmnt > 0){
            invAmnt--;
        }
    }
    
    @Override
    public String toString()
    {
        return "Book ID: " + bID + "\n" + "ISBN: " + ISBN + "\n" + "Title: "+ title+"\n"+"In Stock: "+invAmnt+"\n";
    }
    
    
}
