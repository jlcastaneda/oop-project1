/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

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
    
    public void setDueDate()
    {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //Increment current date by 14 to get due Date
        c.add(Calendar.DATE, 14);
        Date newDate = c.getTime();
        System.out.printf("%s %tB %<te, %<tY\n", 
                         "Due date:", newDate);
        dateDue = newDate;
        
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
}
