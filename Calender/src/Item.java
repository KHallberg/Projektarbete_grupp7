import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Item implements Comparable<Item> {
	private String description;
	private String title;
	// private Date time;
	private Date timeExact;
	private String timeStart;
	private String timeEnd;

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	/*
	 * public Date getTime() { return time; } public void setTime(String
	 * stringTime) { SimpleDateFormat sdf = new SimpleDateFormat(
	 * "dd.MM.yyyy HH:mm:ss"); try { this.time = sdf.parse(stringTime); } catch
	 * (ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public Date getTimeExact() {
		return timeExact;
	}

	public void setTimeExact(String timeExact) {
		// System.out.println("HejHej "+timeExact);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.timeExact = sdf.parse(timeExact);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return this.timeExact.compareTo(o.getTimeExact());
	}
}
