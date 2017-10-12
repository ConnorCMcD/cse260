import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountOccurrenceOfWords {
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<WordOccurrence> words = new ArrayList<WordOccurrence>();
		
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
		
		while(fi.hasNext("\\w+")) {
			String word = fi.next("\\w+");
			for(WordOccurrence w:words) {
				
			}
		}
		fi.close();
	}

}
