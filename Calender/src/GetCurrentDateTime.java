/*MADE BY BADER*/

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetCurrentDateTime {
  public static void main(String[] args) {
	  
	  /*int day, month, year;
      int second, minute, hour;
      GregorianCalendar date = new GregorianCalendar();*/
 

Calendar now = Calendar.getInstance();



String[] strMonths = new String[] { "Januari", "Februari", "Mars", "April", "Maj",
	    "Juni", "Juli", "Augusti", "September", "Oktober", "November", "December"  };
	// Day_OF_WEEK starts from 1 while array index starts from 0

String[] strDays = new String[] { "Söndag", "Måndag", "Tisdag", "Onsdag", "Torsdag",
	    "Fredag", "Lördag" };
	// Day_OF_WEEK starts from 1 while array index starts from 0
	System.out.println("" + strDays[now.get(Calendar.DAY_OF_WEEK) - 1] +" " + now.get(Calendar.DATE) + " " + strMonths[now.get(Calendar.MONTH)]);
	
	/*second = date.get(Calendar.SECOND);
    minute = date.get(Calendar.MINUTE);
    hour = date.get(Calendar.HOUR);

    System.out.println(" "+hour+" : "+minute+"");*/

	
}
}