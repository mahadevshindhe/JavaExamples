package lambda.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Java", "Spring", "Hibernate", "Angular");

		list.stream().forEach((item) -> {
			printName(() -> item);
		});

	}

	private static void printName(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}

}
