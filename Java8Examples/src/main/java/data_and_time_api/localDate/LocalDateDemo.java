package data_and_time_api.localDate;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();

		// Shakespeare was born Apr. 23rd, 1564
		LocalDate dateOfBirth = LocalDate.of(1564, Month.APRIL, 23);

		// When was Shakespeare born?
		
		//Period concept
		Period period = dateOfBirth.until(now);
		System.out.println("# years = " + period.getYears());

		long months = dateOfBirth.until(now, ChronoUnit.MONTHS);
		System.out.println("# months = " + months);

		long days = dateOfBirth.until(now, ChronoUnit.DAYS);
		System.out.println("# days = " + days);

	}

}
