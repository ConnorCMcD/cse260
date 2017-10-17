import java.util.List;

public class PrintMales {
	public static void printMales(List<Person> roster) {
		roster.stream()
		.filter(e -> e.getGender() == Person.Sex.MALE)
		.forEach(e -> System.out.println(e.getName()));
	}
}
