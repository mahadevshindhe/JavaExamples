package lambda.functions;

import java.util.function.Function;

public class FunctionTest {
	
	public static void main(String[] args) {
		
		Function<String, Integer> function = (x) -> x.length();
		
		System.out.println(function.apply("Java"));
	}

}
