package interview;

import java.util.concurrent.TimeUnit;

/*
 * You have thread T1, T2, and T3, how will you ensure that thread T2 run after T1 and thread T3 run after T2?
 */

public class ThreadsRunAfterOneAnother {

	public static void main(String[] args) {
		
		MyRunnable task1 = new MyRunnable();
		MyRunnable task2 = new MyRunnable();
		MyRunnable task3 = new MyRunnable();

		Thread t1 = new Thread(task1, "T1");
		Thread t2 = new Thread(task2, "T2");
		Thread t3 = new Thread(task3, "T3");

		task2.setPredecessor(t1);
		task3.setPredecessor(t2);

		t1.start();
		t2.start();
		t3.start();

		System.out.println("Threads processed.");

	}

	public static class MyRunnable implements Runnable {

		private Thread predecessor;

		@Override
		public void run() {

			System.out.println(Thread.currentThread().getName() + " is started.");

			if (predecessor != null) {
				try {
					predecessor.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				if ("T2".equals(Thread.currentThread().getName())) {
					TimeUnit.SECONDS.sleep(2);
				} else {
					TimeUnit.SECONDS.sleep(5);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is completed.");
		}

		public void setPredecessor(Thread predecessor) {
			this.predecessor = predecessor;
		}

	}

}
