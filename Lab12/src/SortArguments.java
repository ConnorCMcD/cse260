import java.util.Arrays;
import java.util.TreeSet;

public class SortArguments {

	public static void main(String[] args) {
		TreeSet<String> arguments = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		arguments.addAll(Arrays.asList(args));
		
		arguments.stream()
		.forEach(e -> System.out.println(e));
	}

}
