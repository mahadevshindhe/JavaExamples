package semaphore_examples;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore_examples {

	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(1);

		MyThread t1 = new MyThread(semaphore, "T1");
		MyThread t2 = new MyThread(semaphore, "T2");

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Count = " + Shared.count);
	}

}

class MyThread extends Thread {

	private String threadName;
	private Semaphore semaphore;

	public MyThread(Semaphore sem, String threadName) {
		super(threadName);
		this.semaphore = sem;
		this.threadName = threadName;
	}

	@Override
	public void run() {

		System.out.println(threadName + " is acquiring a permit.");

		try {
			semaphore.acquire();
			System.out.println(threadName + " gets a permit");
			for (int i = 0; i < 5; i++) {
				Shared.count++;
				System.out.println("Shared count = " + Shared.count);
				TimeUnit.SECONDS.sleep(5);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		semaphore.release();
		System.out.println(threadName + " releases the permit");

	}
}

class Shared {
	public static int count = 0;
}