import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CountKeywords {
	private static final String[] keywords = {"abstract", 
			"assert", "boolean", "break", "byte", "case", 
			"catch", "char", "class", "const", "continue", 
			"default", "do", "double", "else", "enum", 
			"extends", "for", "final", "finally", "float", 
			"goto", "if", "implements", "import", 
			"instanceof", "int", "interface", "long", 
			"native", "new", "package", "private", 
			"protected", "public", "return", "short", 
			"static", "strictfp", "super", "switch", 
			"synchronized", "this", "throw", "throws", 
			"transient", "try", "void", "volatile", "while", 
			"true", "false", "null"};

	public static int countKeywords(File file) {
		Scanner fi;
		try {
			fi = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return -1;
		}
		HashSet<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
		int count = 0;
		while(fi.hasNext()) {
			String word = fi.next();
			if(word.startsWith("/*")) {
				while(!word.endsWith("*/")) {
					if(fi.hasNext()) {
						fi.next();
					}else {
						System.out.println("File ended with"
								+ "unclosed comment");
						fi.close();
						return count;
					}
				}
			}else if(word.startsWith("\"")) {
				while(!word.endsWith("\"")) {
					if(fi.hasNext()) {
						fi.next();
					}else {
						System.out.println("File ended with"
								+ "unclosed String");
						fi.close();
						return count;
					}
				}
			}else if(word.startsWith("//")) {
				if(fi.hasNextLine()) {
					fi.nextLine();
				}else {
					fi.close();
					return count;
				}
			}else if(keywordSet.contains(word)) {
				count++;
			}
		}
		fi.close();
		return count;
	}
}
