package lambda.functions;

import java.util.function.BiPredicate;

public class BiPredicateTest {

	public static void main(String[] args) {
		
		BiPredicate<Integer, Integer> predicate = (x, y) -> x > y;

		System.out.println(predicate.test(10, 30));
	}

}
