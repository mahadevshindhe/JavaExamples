package lambda.functions;

import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {

		Consumer<String> consumer = ConsumerTest::printNames;

		consumer.accept("Java");
		consumer.accept("Spring Boot");

	}

	private static void printNames(String name) {
		System.out.println(name);
	}

}
