package se.mah.k3;
import java.text.DecimalFormat;
import java.util.Calendar;

public class TimeAndDate {
	
	public static String[] strDays = new String[] {"Lördag" ,"Söndag", "Måndag", "Tisdag", "Onsdag", "Torsdag",
			    "Fredag"};
	  
	public static String[] strMonths = new String[] { "Januari", "Februari", "Mars", "April", "Maj",
			    "Juni", "Juli", "Augusti", "September", "Oktober", "November", "December"  };
	
	private Kalender_v2 clockGUI;
	public TimeAndDate(Kalender_v2 MyTestGUI) {
		this.clockGUI = MyTestGUI;
		
		new ClockThread().start();
		
	}
	
	private class ClockThread extends Thread {
		@Override
		public void run() {
			while (true) {
				Calendar cal = Calendar.getInstance();
				int hour = cal.get(cal.HOUR_OF_DAY);
				int minute = cal.get(cal.MINUTE);
				int second = cal.get(cal.SECOND);
				int weekday = cal.get(cal.DAY_OF_WEEK);
				int date = cal.get(cal.DATE);
				int month = cal.get(cal.MONTH);
				
				DecimalFormat correctTime = new DecimalFormat("00");
				//Kalender_v2.setTimeOnLabel(correctTime.format(hour) + ":" + correctTime.format(minute));
				//Kalender_v2.setDateOnLabel(strDays[weekday] + " " + date + " " + strMonths[month]);
				//clockGUI.setTimeOnLabel(hour + ":" + minute + ":" + second);
				
				try {
					Thread.sleep(900);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}

			}

		}
	}

}
