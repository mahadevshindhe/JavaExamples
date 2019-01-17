package semaphore_examples;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore_examples2 {

	static Semaphore semaphore = new Semaphore(5);

	public static void main(String[] args) {

		System.out.println("Total avilable semaphore permits : " + semaphore.availablePermits());

		for (int i = 1; i < 20; i++) {
			new MyThread("Thread" + i).start();
		}

	}

	public static class MyThread extends Thread {

		private String name;

		public MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println(name + " : acquiring lock");
			System.out.println(name + " : available semaphore permits now " + semaphore.availablePermits());

			try {
				semaphore.acquire();
				for (int i = 0; i < 5; i++) {
					//System.out.println(name + " : performing operation " + i);
					//System.out.println(name + " : available semaphore permits" + semaphore.availablePermits());
				}
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
				System.out.println(name + " : releasing lock");
				System.out.println(name + " : available semaphore permits now" + semaphore.availablePermits());
			}
		}
	}

}
