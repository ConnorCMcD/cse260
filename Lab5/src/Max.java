
public class Max {
	public static <E extends Comparable<E>> E max(E[] list) {
		E maximum = list[0];
		for(int i=1; i<list.length; i++) {
			if(maximum.compareTo(list[i])<0) {
				maximum = list[i];
			}
		}
		return maximum;
	}
}
