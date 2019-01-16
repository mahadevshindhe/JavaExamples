package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

	public static void main(String[] args) {
		
		/*Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		};*/
		
		Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		
		List<String> list = Arrays.asList("***", "**", "****", "*");
		list.sort(comparator);
		
		list.forEach( System.out::println);

	}

}
