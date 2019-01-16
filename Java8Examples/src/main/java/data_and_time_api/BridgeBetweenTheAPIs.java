package data_and_time_api;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class BridgeBetweenTheAPIs {

	public static void main(String[] args) {

		//Instant and Date
		Instant instant = Instant.now();
		Date date = Date.from(instant ); // legacy -> new API
		Instant instant2 = date.toInstant(); // API -> legacy
		
		//Instant and TimeStamp
		Timestamp time = Timestamp.from(instant); // legacy -> new API
		Instant instant3 = time.toInstant(); // API -> legacy
		
		//LocalDate and Date
		Instant localDate = Instant.now();
		Date date2 = Date.from(localDate); // legacy -> new API
		//LocalDate localDate2 = date2.toLocalDate(); // API -> legacy
		
		//LocalTime and Time
		LocalTime localTime  = LocalTime.now();
		//Time time2 = Time.from(localTime); // legacy -> new API
		//LocalTime localTime2 = time.toLocalTime(); // API -> legacy
	}

}
