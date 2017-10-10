import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class NonduplicateWords {
	public static void nonduplicateWords(File f) {
		TreeSet<String> words = new TreeSet<String>();
		Scanner fi;
		try {
			fi = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}
		while(fi.hasNext()) {
			String w = fi.next().toUpperCase();
			if(!words.contains(w)) {
				words.add(w);
			}
		}
		fi.close();
		System.out.println(words.toString());
	}
}
