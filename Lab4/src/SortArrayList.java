import java.util.ArrayList;

public class SortArrayList {
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<i; j++) {
				if(list.get(i).compareTo(list.get(j)) < 0) {
					list.add(i,list.remove(j));
					break;
				}
			}
		}
	}
}
