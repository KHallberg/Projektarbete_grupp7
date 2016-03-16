
public class Item implements Comparable{
private String description;
private String title;
private String time;
private String timeExact;
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
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getTimeExact() {
	return timeExact;
}
public void setTimeExcact(String timeExact) {
	this.timeExact = timeExact;
}
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	return 0;
}

}
