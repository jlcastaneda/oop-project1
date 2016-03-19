/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_bookmart;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author Stephen Maddux
 * Current Date function
 * 
 */
public class DueDate {

    private Date dateDue;
    
    public DueDate()
    {
        
    }
    
    public Date currentDate(){  //added by Josh
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return date;
    }
    
    
    public Date dueDate(int student, int staff)  //modified by Josh
    {
        int incr = 0;
        if(student == 1){
            incr = 7;
        }
        if(staff == 1){
            incr = 14;
        }
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //Increment current date by incr to get due Date
        c.add(Calendar.DATE, incr);
        Date newDate = c.getTime();
        //System.out.printf("%s %tB %<te, %<tY\n", 
        //                 "Due date:", newDate);
        dateDue = newDate;
        return newDate;
    }
    
    public Date returnDue()
    {
        return dateDue;
    }
    
    //Check if book is overdue function
   public void checkifOverdue()
   {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       System.out.println(sdf.format(date));
       System.out.println(sdf.format(dateDue));
       if(date.compareTo(dateDue)>0){
        		System.out.println("Book is overdue");
        	}else if(date.compareTo(dateDue)<0){
        		System.out.println("Book is not due yet");
        	}else if(date.compareTo(dateDue)==0){
        		System.out.println("Last day");
        	}else{
        		System.out.println("Error");
        	}
   }
   
   //Calculate days book is Overdue
   public void OverdueCalculate()
   {
       Date current = currentDate();
       Date due = returnDue();
        
       //Get difference in current date and due date
        long diff = current.getTime() - due.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        int diffInDays = (int) ((current.getTime() - due.getTime()) / (1000 * 60 * 60 * 24));       
        System.out.println("This book is " + diffInDays + " days overdue.");
                         
   }
}
