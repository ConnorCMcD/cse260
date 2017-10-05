import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class LinkedListTimeTest {
	private static Random random = new Random();
	private static final int LIST_SIZE = 100000;
	
	public static void main(String[] args) {
		System.out.println("Generating List size "+LIST_SIZE);
		LinkedList<Integer> list = genList();
		System.out.println("List generated");
		System.out.println("Testing for-each loop");
		long startTime = System.currentTimeMillis();
		for(int i=0;i<LIST_SIZE;i++) {
			list.get(i);
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");
		System.out.println("Testing Iterator");
		Iterator<Integer> it = list.iterator();
		startTime = System.currentTimeMillis();
		while(it.hasNext()) {
			it.next();
		}
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");
	}
	
	private static LinkedList<Integer> genList(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<LIST_SIZE;i++) {
			list.add(random.nextInt());
		}
		return list;
	}

}
