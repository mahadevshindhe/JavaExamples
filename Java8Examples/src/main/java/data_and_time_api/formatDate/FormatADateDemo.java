package data_and_time_api.formatDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatADateDemo {

	public static void main(String[] args) {

		ZonedDateTime currentMeeting = ZonedDateTime.of(LocalDate.of(2014, Month.MARCH, 12), LocalTime.of(9, 30),
				ZoneId.of("Europe/London"));

		ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(1));
		ZonedDateTime nextMeetingUS = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));

		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUS));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUS));
	}

}
