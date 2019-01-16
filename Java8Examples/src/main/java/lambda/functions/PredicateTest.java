package lambda.functions;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		
		Predicate<Integer> lesserPredicate = i -> i < 18;
		Predicate<Integer> greaterPredicate = i -> i > 50;
		
		boolean test = lesserPredicate.test(10);
		System.out.println(test);

		boolean test2 = lesserPredicate.and(greaterPredicate).test(20);
		System.out.println(test2);
	}

}
