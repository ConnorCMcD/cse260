import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class StoreLinkedList {
	private static Scanner input = new Scanner(System.in);
	private static Random random = new Random();
	
	public static void main(String[] args) {
		System.out.println("Input integers followed by enter,\ninput \"q\" to end input");
		LinkedList<Integer> nums = new LinkedList<Integer>();
		while(input.hasNext()) {
			if(input.hasNextInt()) {
				int n = input.nextInt();
				if(!nums.contains(n)) {
					nums.add(n);
				}else {
					System.out.println("Number already in list");
				}
			}else if(input.next().equals("q")) {
				break;
			}else {
				System.out.println("Invalid Input");
			}
		}
		LinkedList<Integer> sortedNums = (LinkedList<Integer>) nums.clone();
		Collections.sort(sortedNums);
		System.out.println("Sorted:");
		for(int n:sortedNums) {
			System.out.println(n);
		}
		LinkedList<Integer> shuffledNums = (LinkedList<Integer>) nums.clone();
		for(int i=0;i<shuffledNums.size();i++) {
			int n = shuffledNums.get(i);
			int index = random.nextInt(shuffledNums.size()-i)+i;
			shuffledNums.set(i, shuffledNums.get(index));
			shuffledNums.set(index, n);
		}
		System.out.println("Shuffled:");
		for(int n:shuffledNums) {
			System.out.println(n);
		}
		LinkedList<Integer> reversedNums = (LinkedList<Integer>) nums.clone();
		for(int i=0;i<(reversedNums.size()/2);i++) {
			int n = reversedNums.get(i);
			int index = reversedNums.size() - (i+1);
			reversedNums.set(i, reversedNums.get(index));
			reversedNums.set(index, n);
		}
		System.out.println("Reversed:");
		for(int n:reversedNums) {
			System.out.println(n);
		}
	}

}
