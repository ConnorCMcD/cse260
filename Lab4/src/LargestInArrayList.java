import java.util.ArrayList;

public class LargestInArrayList {
	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = list.get(0);
		for(int i=1; i<list.size(); i++) {
			if(list.get(i).compareTo(max) > 0) {
				max = list.get(i);
			}
		}
		return max;
	}
}
