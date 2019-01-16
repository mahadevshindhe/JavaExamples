package lambda.functions;

import java.util.function.BiFunction;

public class BiFunctionTest {

	public static void main(String[] args) {

		BiFunction<String, String, String> function = (a, b) -> {
			return a + " " + b;
		};

		System.out.println(function.apply("Java", "Programming"));
	}

}
