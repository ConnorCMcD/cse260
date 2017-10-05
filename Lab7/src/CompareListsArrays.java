import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class CompareListsArrays {
	private static Random random = new Random();
	private static final int LIST_SIZE = 500000;
	public static void main(String[] args) {
		System.out.println("Generating LinkedList size "+LIST_SIZE);
		long startTime = System.currentTimeMillis();
		LinkedList<Integer> lList = genLList();
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");

		startTime = System.currentTimeMillis();
		System.out.println("Generating ArrayList size "+LIST_SIZE);
		ArrayList<Integer> aList = genAList();
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");

		startTime = System.currentTimeMillis();
		System.out.println("Generating Array size "+LIST_SIZE);
		int[] array = genArray();
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");
		
		System.out.println("Testing LinkedList Iterator");
		Iterator<Integer> it = lList.iterator();
		startTime = System.currentTimeMillis();
		while(it.hasNext()) {
			it.next();
		}
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");
		
		System.out.println("Testing ArrayList Iterator");
		it = aList.iterator();
		startTime = System.currentTimeMillis();
		while(it.hasNext()) {
			it.next();
		}
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");
		
		System.out.println("Testing Array for loop");
		startTime = System.currentTimeMillis();
		for (int i=0; i < LIST_SIZE; i++) {
			int n = array[i];
		}
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");
		
		System.out.println("Testing LinkedList Removal");
		startTime = System.currentTimeMillis();
		while(!lList.isEmpty()) {
			lList.removeFirst();
		}
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");
		
		System.out.println("Testing ArrayList Removal");
		startTime = System.currentTimeMillis();
		while(!aList.isEmpty()) {
			aList.remove(0);
		}
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");

		System.out.println("Testing Array Removal");
		startTime = System.currentTimeMillis();
		for (int i=0; i < LIST_SIZE; i++) {
			array[i] = 0;
		}
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Finished after "+executionTime+" ms");
	}
	private static LinkedList<Integer> genLList(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<LIST_SIZE;i++) {
			list.add(random.nextInt());
		}
		return list;
	}
	private static ArrayList<Integer> genAList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<LIST_SIZE;i++) {
			list.add(random.nextInt());
		}
		return list;
	}
	private static int[] genArray(){
		int[] array = new int[LIST_SIZE];
		for(int i=0;i<LIST_SIZE;i++) {
			array[i] = random.nextInt();
		}
		return array;
	}
}
