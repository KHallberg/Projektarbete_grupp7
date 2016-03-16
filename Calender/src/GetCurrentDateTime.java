import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

public class GetCurrentDateTime implements Runnable {
	
	
	public Thread thread = new Thread();
	boolean running= false;
	
	
	int day, month, year;
    int second, minute, hour;
    GregorianCalendar date = new GregorianCalendar();{

   
    /*second = date.get(Calendar.SECOND);*/
    minute = date.get(Calendar.MINUTE);
    hour = date.get(Calendar.HOUR_OF_DAY);}

    /*System.out.println(" "+hour+" : "+minute+"");*/
	
	
	
        
        
	
  public static String[] strDays = new String[] { "Söndag", "Måndag", "Tisdag", "Onsdag", "Torsdag",
		    "Fredag", "Lördag" };
  
  public static String[] strMonths = new String[] { "Januari", "Februari", "Mars", "April", "Maj",
		    "Juni", "Juli", "Augusti", "September", "Oktober", "November", "December"  };

  
  
  public void start() {
      running = true;
       new Thread(this).start();
  }
  
  public void run() {

	    while(running) {

	        /*System.out.println("test");*/

	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	}
  
  
public static void main(String[] args) {
	
	
	
	
	
	
	
	  
	  /*public String [] strMonths = new String [12];
	  public String [] strDays = new String [1];*/
	  
	 /*final String[] strMonths = new String[] { "Januari", "Februari", "Mars", "April", "Maj",
	    "Juni", "Juli", "Augusti", "September", "Oktober", "November", "December"  };
	// Day_OF_WEEK starts from 1 while array index starts from 0

final String[] strDays = new String[] { "Söndag", "Måndag", "Tisdag", "Onsdag", "Torsdag",
	    "Fredag", "Lördag" };*/
	  
	  
new GetCurrentDateTime().start();
	  
	  
	  
	  /*int day, month, year;
      int second, minute, hour;
      GregorianCalendar date = new GregorianCalendar();*/
 

Calendar now = Calendar.getInstance();





 /*String[] strMonths = new String[] { "Januari", "Februari", "Mars", "April", "Maj",
	    "Juni", "Juli", "Augusti", "September", "Oktober", "November", "December"  };
	// Day_OF_WEEK starts from 1 while array index starts from 0

String[] strDays = new String[] { "Söndag", "Måndag", "Tisdag", "Onsdag", "Torsdag",
	    "Fredag", "Lördag" };*/
	// Day_OF_WEEK starts from 1 while array index starts from 0
	System.out.println("" + strDays[now.get(Calendar.DAY_OF_WEEK) - 1] +" " + now.get(Calendar.DATE) + " " + strMonths[now.get(Calendar.MONTH)]);
	System.out.println(""+now.get(Calendar.MINUTE));
	/*second = date.get(Calendar.SECOND);
    minute = date.get(Calendar.MINUTE);
    hour = date.get(Calendar.HOUR);

    System.out.println(" "+hour+" : "+minute+"");*/
	
	
	
}
}