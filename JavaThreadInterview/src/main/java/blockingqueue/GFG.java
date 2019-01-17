package blockingqueue;
import java.util.concurrent.ArrayBlockingQueue;

public class GFG {
	public static void main(String[] args) throws InterruptedException {

		// define capacity of ArrayBlockingQueue
		int capacity = 5;

		// create object of ArrayBlockingQueue
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(capacity);

		// Add elements to ArrayBlockingQueue using put method
		queue.put("StarWars");
		queue.put("SuperMan");
		queue.put("Flash");
		queue.put("BatMan");
		queue.put("Avengers");

		// print Queue
		System.out.println("queue contains " + queue);

		// remove some elements
		queue.remove();
		queue.remove();

		// Add elements to ArrayBlockingQueue
		// using put method
		queue.put("CaptainAmerica");
		queue.put("Thor");

		System.out.println("queue contains " + queue);
	}
}
