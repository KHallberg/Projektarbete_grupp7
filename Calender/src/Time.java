import java.util.*;

class Time implements Runnable
{
	
	public Thread thread = new Thread();
	boolean running= false;
	
   public static void main(String args[])
   {
      int day, month, year;
      int second, minute, hour;
      GregorianCalendar date = new GregorianCalendar();
 
     
      /*second = date.get(Calendar.SECOND);*/
      minute = date.get(Calendar.MINUTE);
      hour = date.get(Calendar.HOUR_OF_DAY);
 
      System.out.println(" "+hour+" : "+minute+"");
   }
   
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
}