package interview;
public class TwoThreadsPrintSequentialNumbersDemo {

	public static void main(String[] args) {
		
		Printer print = new Printer();
		
		Runnable printEvenTask = new OddEvenThread(print , 10, true);
		Runnable printOddTask = new OddEvenThread(print , 10, false);
		
		Thread thread1 = new Thread(printEvenTask );
		Thread thread2 = new Thread(printOddTask );
		
		thread1.start();
		thread2.start();

	}

	public static class OddEvenThread implements Runnable {
		
		private Printer print;
		private int max;
		private boolean isEvenNumber;

		public OddEvenThread(Printer print, int max, boolean isEvenNumber) {
			this.print = print;
			this.max = max;
			this.isEvenNumber = isEvenNumber;
		}

		@Override
		public void run() {

			int number = (isEvenNumber == true) ? 2 : 1;
			while (number <= max) {
				String threadName = Thread.currentThread().getName();
				if (isEvenNumber) {
					print.printEven(number, threadName);
				} else {
					print.printOdd(number,threadName);
				}

				number += 2;
			}
		}

	}

	public static class Printer {
		boolean isOdd = false;

		public synchronized void printEven(int number, String threadName) {

			while (isOdd == false) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Thread: "+threadName+" Even : " + number);
			isOdd = false;
			notifyAll();
		}

		public synchronized void printOdd(int number, String threadName) {

			while (isOdd == true) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Thread: "+threadName+" Odd : " + number);
			isOdd = true;
			notifyAll();
		}
	}

}
