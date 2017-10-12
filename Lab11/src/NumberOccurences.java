import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberOccurences {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<Integer,Integer> intCounts = new HashMap<Integer,Integer>();
		
		System.out.println("Input ints (Ctrl + Z to stop input):");
		while(input.hasNextInt()) {
			int i = input.nextInt();
			if(intCounts.containsKey(i)) {
				intCounts.put(i, intCounts.get(i)+1);
			}else {
				intCounts.put(i,1);
			}
		}
		
		Set<Integer> keys = intCounts.keySet();
		HashSet<Integer> modes = new HashSet<Integer>();
		int mostOccurances = 0;
		for(int key:keys) {
			if(intCounts.get(key)>mostOccurances) {
				modes.clear();
				mostOccurances = intCounts.get(key);
				modes.add(key);
			}else if(intCounts.get(key)==mostOccurances) {
				modes.add(key);
			}
		}
		System.out.println("The most commonally occuring integer(s) were:");
		System.out.println(modes.toString());
		System.out.println("with "+mostOccurances+" occurances( each).");
	}
}
