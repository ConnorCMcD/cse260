import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

public class TestLab10 {
	
	/**
	 * This java doc is for the purpose of testing keyword count
	 * int new void private static null true catch
	 */
	public static void main(String[] args) {
		String[] a1 = {"George", "Jim", "John", "Blake", 
				"Kevin", "Michael"};
		String[] a2 = {"George", "Katie", "Kevin", 
				"Michelle", "Ryan"};
		HashSet<String> s1 = new HashSet<String>(Arrays.asList(a1));
		HashSet<String> s2 = new HashSet<String>(Arrays.asList(a2));
		System.out.println("Set 1: " + s1.toString());
		System.out.println("Set 2: " + s2.toString());
		HashSet<String> union = SetOperations.union(s1, s2);
		System.out.println("Union: " + union.toString());
		HashSet<String> intersection = 
				SetOperations.intersection(s1, s2);
		System.out.println("Intesection: " + 
				intersection.toString());
		HashSet<String> d12 = SetOperations.difference(s1, s2);
		System.out.println("Difference (s1-s2): " 
				+ d12.toString());
		HashSet<String> d21 = SetOperations.difference(s2, s1);
		System.out.println("Difference (s2-s1): " 
				+ d21.toString());
		
		File file = new File("TestFile.txt");
		System.out.println("\nNonduplicate words of the Gettysurg Address:");
		NonduplicateWords.nonduplicateWords(file);
		
		//These comments are for testing CountKeywords
		//int boolean
		File file2 = new File("src\\CountKeywords.java");
		System.out.println("\n" + CountKeywords.countKeywords(file2));
	}

}
