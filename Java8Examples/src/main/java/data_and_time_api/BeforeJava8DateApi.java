package data_and_time_api;

import java.util.Calendar;
import java.util.Date;

public class BeforeJava8DateApi {

	public static void main(String[] args) {
		//One class : java.util.Date (and java.sql.Date) [JDK 1.0]
		
		Date date = new Date();
		
		//How can I create a date for the 2014 / 2 / 10?
		//I must use the Calendar class
		
		Calendar cal = Calendar.getInstance();
		//cal.set(year, month, date);
		cal.set(2014, 1, 10);
		
		Date feb10th = cal.getTime();
		System.out.println(feb10th);
		
		//How can I add 7 days to feb10th?
		cal.add(Calendar.DAY_OF_MONTH, 7);
		Date oneWeekLater = cal.getTime();
		System.out.println(oneWeekLater);
		
		
	}
}
