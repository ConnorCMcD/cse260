import java.util.Random;
import java.util.Scanner;

public class TestLab5 {
	
	private static Scanner input = new Scanner(System.in);		

	public static void main(String[] args) {
		GenericStack<String> strings = new GenericStack<String>();
		System.out.println("Input first string:");
		strings.push(input.nextLine());
		System.out.println("Input second string:");
		strings.push(input.nextLine());
		System.out.println("Input third string:");
		strings.push(input.nextLine());
		System.out.println("Input fourth string:");
		strings.push(input.nextLine());
		System.out.println("Input fifth string:");
		strings.push(input.nextLine());
		String[] list = new String[0];
		list = strings.toArray(list);
		System.out.println("Strings in reverse:");
		while(!strings.isEmpty()) {
			System.out.println(strings.pop());
		}
		
		System.out.println("\nThe input string with the greatest value was:");
		System.out.println(Max.max(list));

		Random random = new Random();
		String[] lib = new String[26];
		System.out.println("\nLibrary of Strings in Alphabetical Order:");
		for(int i=0; i<26; i++) {
			lib[i] = "" + (char)(65+i);
			int extra = random.nextInt(6)+5;
			for(int j=0; j<extra; j++) {
				lib[i] += (char)(random.nextInt(26)+65);
			}
			System.out.println(lib[i]);
		}
		System.out.println("Input key to search above library:");
		String key = input.nextLine();
		int location = BinarySearch.binarySearch(lib, key);
		if(location < 0) {
			System.out.println("Key not found.  Return: " + location);
		}else {
			System.out.println("Key found at location: " + location);
		}
		return;
	}

}
