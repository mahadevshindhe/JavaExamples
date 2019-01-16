package stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stream.model.Person;

public class CollectorsExample {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));

		Stream<String> lines = reader.lines();

		lines.map(line -> {
			String[] s = line.split(" ");
			Person person = new Person(s[0].trim(), Integer.parseInt(s[1]));
			persons.add(person);
			return person;
		}).forEach(System.out::println);

		Optional<Person> opt = persons.stream().filter(p -> p.getAge() >= 20).min(Comparator.comparing(Person::getAge));

		Optional<Person> opt2 = persons.stream().max(Comparator.comparing(Person::getAge));

		System.out.println("> Youngest:  " + opt.get());
		System.out.println("> Oldest:  " + opt2.get());

		Map<Integer, String> collect = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(", "))));

		System.out.println(collect);
	}

}
