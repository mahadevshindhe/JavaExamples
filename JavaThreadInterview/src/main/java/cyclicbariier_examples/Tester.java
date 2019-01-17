package cyclicbariier_examples;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Tester implements Runnable {

	public static CyclicBarrier cb = new CyclicBarrier(3);

	public static void main(String[] args) {

		Tester tester = new Tester();
		Thread thread = new Thread(tester);
		thread.start();
	}

	@Override
	public void run() {
		
		Thread c1 = new Thread(new Computation1(), "Computation1");
		Thread c2 = new Thread(new Computation2(), "Computation2");
		
		c1.start();
		c2.start();
		
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sum = " + (Computation1.product + Computation2.sum));
	}

}

class Computation1 implements Runnable {

	public static int product = 0;

	@Override
	public void run() {
		product = 2 * 3;
		try {
			Tester.cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}

class Computation2 implements Runnable {
	public static int sum = 0;

	@Override
	public void run() {
		sum = 10 + 20;
		try {
			Tester.cb.await(3000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

}
