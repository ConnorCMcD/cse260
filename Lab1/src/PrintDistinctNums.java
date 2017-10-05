import java.util.Arrays;

public class PrintDistinctNums {
	public static void printDistinctNums(int[] nums) {
        int distinct[] = new int[0];
        for(int i=0; i<nums.length; i++) {
            boolean isDistinct = true;
            for(int j=0; j<distinct.length; j++) {
            	if(nums[i] == distinct[j]) {
            		isDistinct = false;
            	}
            }
            if(isDistinct) {
            	distinct = Arrays.copyOf(distinct,  distinct.length + 1);
            	distinct[distinct.length - 1] = nums[i];
            }
        }
        for(int i=0; i<distinct.length; i++) {
        	System.out.println(distinct[i]);
        }
    }
}
