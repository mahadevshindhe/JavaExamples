package interview;

import java.util.concurrent.TimeUnit;

/*
 * You have thread T1, T2, and T3, how will you ensure that thread T2 run after T1 and thread T3 run after T2?
 */

public class ThreadsRunAfterOneAnother_simple {

	private static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is started");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is finished");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable runnable1 = new MyRunnable();
		MyRunnable runnable2 = new MyRunnable();
		MyRunnable runnable3 = new MyRunnable();
		
		Thread t1 = new Thread(runnable1, "T1");
		Thread t2 = new Thread(runnable2, "T2");
		Thread t3 = new Thread(runnable3, "T3");
		
		t1.start();
		t1.join();

		t2.start();
		t2.join();
		
		t3.start();
		t3.join();
	}
}
