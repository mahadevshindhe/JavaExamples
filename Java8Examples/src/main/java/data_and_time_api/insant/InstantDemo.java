package data_and_time_api.insant;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class InstantDemo {
	
	public static void main(String[] args) {
		//Instant
		Instant now = Instant.now();
		
		System.out.println(Instant.MAX); //Dec. 31 of the year 1,000,000,000
		System.out.println(Instant.MIN); //1 billion years ago
		
		//Instant is immutable
		Instant start = Instant.now();

		//longer operation
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Instant end = Instant.now();
		
		Duration elapsed = Duration.between(start, end);
		long millis = elapsed.toMillis();
		System.out.println("elpased time :" + millis);
		
	}

}
