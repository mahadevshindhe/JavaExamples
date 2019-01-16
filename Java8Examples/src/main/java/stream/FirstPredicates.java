package stream;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {
	
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		
		Predicate<String> p1 = s -> s.length() >3 ;
		Predicate<String> p2 = s -> s.contains("two") ;
		Predicate<String> p3 = s -> s.contains("three");
		
//		Consumer<String> print = System.out::println;
//		stream.filter(p2.or(p3)).forEach(print);
		stream.filter(p2.or(p3)).forEach(System.out::println);
		
	}

}
