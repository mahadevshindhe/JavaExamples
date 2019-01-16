package data_and_time_api.localTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.function.Function;

public class ZoneTimeDemo {

	public static void main(String[] args) {
		
		// Java uses the IANA database (https://www.iana.org/time-zones)
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();

		Function<Set<String>, Integer> lengthFunction = s -> s.size();

		System.out.println("#Total zones = " + lengthFunction.apply(zoneIds));
		// All zone names
		// zoneIds.forEach( System.out::println);

		ZoneId ukTZ = ZoneId.of("Europe/London");

		System.out.println(ZonedDateTime.of(1564, Month.APRIL.getValue(), 23, 10, 0, 0, 0, ZoneId.of("Europe/London")));

		ZonedDateTime currentMeeting = ZonedDateTime.of(LocalDate.of(2014, Month.MARCH, 12), LocalTime.of(9, 30),
				ZoneId.of("Europe/London"));
		
		ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(1));

	}

}
