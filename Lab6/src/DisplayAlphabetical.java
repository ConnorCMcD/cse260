import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DisplayAlphabetical {
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.println("Input file pathname to be read:");
		String path = input.nextLine();
		File file = new File(path);
		if(!file.exists()) {
			System.out.print("File does not exist at " + path);
			return;
		}
		Scanner fileInput;
		try {
			fileInput = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		ArrayList<String> words = new ArrayList<String>();
		while(fileInput.hasNext()) {
			words.add(fileInput.next());
		}
		fileInput.close();
		Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Alphabetical Order:");
		for(String word : words) {
			System.out.println(word);
		}
		return;
	}
}
