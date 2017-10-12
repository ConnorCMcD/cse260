import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Letters {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<Character,Integer> vowelCounts = new HashMap<Character, Integer>();
		vowelCounts.put('A', 0);
		vowelCounts.put('E', 0);
		vowelCounts.put('I', 0);
		vowelCounts.put('O', 0);
		vowelCounts.put('U', 0);
		int consonantCount = 0;
		
		System.out.println("Input text file name:");
		File file = new File(input.nextLine());
		if(!file.exists()) {
			System.out.println("File does not exist.");
			return;
		}
		Scanner fi;
		try {
			fi = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		while(fi.hasNext()) {
			char[] chars = fi.next().toCharArray();
			for(char c:chars) {
				if(Character.isAlphabetic(c)) {
					c = Character.toUpperCase(c);
					if(vowelCounts.containsKey(c)) {
						vowelCounts.put(c, vowelCounts.get(c)+1);
					}else {
						consonantCount++;
					}
				}
			}
		}
		fi.close();
		
		System.out.println("In "+file.getName()+" there was:");
		System.out.println(consonantCount+" consonants");
		System.out.println(vowelCounts.get('A')+" \'A\'s");
		System.out.println(vowelCounts.get('E')+" \'E\'s");
		System.out.println(vowelCounts.get('I')+" \'I\'s");
		System.out.println(vowelCounts.get('O')+" \'O\'s");
		System.out.println(vowelCounts.get('U')+" \'U\'s");
		
	}

}
