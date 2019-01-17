package blockingqueue;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {

	public static void main(String[] args) {
		
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		
		queue.add("Karntaka");
		//queue.add(null);  //java.lang.NullPointerException
		
		System.out.println("Remaining capacity after adding Karnataka : "+ queue.remainingCapacity());
		queue.add("Maharastra");
		
		//Queue full: java.lang.IllegalStateException
		//queue.add("Tamilnadu");
		System.out.println("Remaining capacity after adding Maharastra: "+ queue.remainingCapacity());
		
		System.out.println(queue.element()); //does not remove element
		
		queue.forEach(q -> {
			System.out.println(q);
		});
	}
}
