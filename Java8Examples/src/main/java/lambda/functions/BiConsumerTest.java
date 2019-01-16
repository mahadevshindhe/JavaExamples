package lambda.functions;

import java.util.function.BiConsumer;

public class BiConsumerTest {

	public static void main(String[] args) {

		BiConsumer<String, String> consumer = BiConsumerTest::printNames;

		consumer.accept("ORM", "Hibernate");
		consumer.accept("Database", "DB2");

	}

	private static void printNames(String s1, String s2) {
		System.out.println(s1 + " -> " + s2);
	}

}
