package lambda;

public class RunnableLambda {

	public static void main(String[] args) {

/*		Runnable runnable = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		};
		
		new Thread(runnable).start();
*/
		new Thread(() -> {
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}).start();
	}

}
