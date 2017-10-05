import java.util.Arrays;
import java.util.Random;

public class TimingExecution {
	public static void main(String args[]) {
		Random random = new Random();
		System.out.println("Generating Array");
		int[] list = genArray(random);
		System.out.println("Array generated");
		int key = random.nextInt(100000);
		System.out.println("Key: " + key);
		System.out.println("Preforming linear search");
		long startTime = System.currentTimeMillis();
		int i = linearSearch(list, key);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		if(i<0) {
			System.out.println("Key not found.");
		}else {
			System.out.println("Key found at element " + i);
		}
		System.out.println("Execution Time = " + executionTime + " ms");
		System.out.println("Sorting Array");
		Arrays.sort(list);
		System.out.println("Array sorted");
		System.out.println("Preforming binary search");
		startTime = System.currentTimeMillis();
		i = binarySearch(list, key);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		if(i<0) {
			System.out.println("Key not found.");
		}else {
			System.out.println("Key found at element " + i);
		}
		System.out.println("Execution Time = " + executionTime + " ms");
	}
	
	public static int[] genArray(Random random) {
		int nums[] = new int[100000];
		for(int i=0; i<nums.length; i++) {
			nums[i] = random.nextInt(100000);
		}
		return nums;
	}
	
	public static int linearSearch(int[] list, int key) {
		for(int i=0; i<list.length; i++) {
			if(key == list[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		while(high>=low) {
			int mid = (low + high)/2;
			if(key < list[mid]) {
				high = mid - 1;
			}else if(key == list[mid]) {
				return mid;
			}else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
