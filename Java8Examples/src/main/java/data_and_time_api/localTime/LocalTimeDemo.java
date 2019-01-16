package data_and_time_api.localTime;

import java.time.LocalTime;

public class LocalTimeDemo {

	public static void main(String[] args) {

		LocalTime now = LocalTime.now();
		System.out.println("#now = " + now);

		LocalTime bedTime = LocalTime.of(23, 30);
		System.out.println("#bedTime = " + bedTime);

		// other methods
		LocalTime wakaeupHours = bedTime.plusHours(8);
		System.out.println("#wakeup = " + wakaeupHours);
		
	}

}
