import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Letters {
	
	public static HashMap<Character,Integer> countLetters(File file) {
		HashMap<Character,Integer> letterCounts = new HashMap<Character, Integer>();
		for(char c = 'A'; c <= 'Z'; c++) {
			letterCounts.put(c, 0);
		}
		
		
		if(!file.exists()) {
			System.out.println("File does not exist.");
			return null;
		}
		Scanner fi;
		try {
			fi = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return null;
		}
		
		while(fi.hasNext()) {
			char[] chars = fi.next().toCharArray();
			for(char c:chars) {
				if(Character.isAlphabetic(c)) {
					c = Character.toUpperCase(c);
					if(letterCounts.containsKey(c)) {
						letterCounts.put(c, letterCounts.get(c)+1);
					}
				}
			}
		}
		fi.close();
		return letterCounts;
	}

}
