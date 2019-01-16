package data_and_time_api.localDate;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.temporal.TemporalAdjusters;

public class DateAdjusterDemo {

	public static void main(String[] args) {

		Instant now = Instant.now();

		Instant nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(nextSunday);
	}

}
