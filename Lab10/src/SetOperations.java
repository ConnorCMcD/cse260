import java.util.HashSet;

public class SetOperations {
	public static <E> HashSet<E> union(HashSet<E> s1, HashSet<E> s2){
		HashSet<E> union = new HashSet<E>();
		for(E e:s1) {
			union.add(e);
		}
		for(E e:s2) {
			if(!union.contains(e)) {
				union.add(e);
			}
		}
		return union;
	}
	public static <E> HashSet<E> intersection(HashSet<E> s1, HashSet<E> s2){
		HashSet<E> intersection = new HashSet<E>();
		for(E e:s1) {
			if(s2.contains(e)) {
				intersection.add(e);
			}
		}
		return intersection;
	}
	public static<E> HashSet<E> difference(HashSet<E> s1, HashSet<E> s2){
		HashSet<E> difference = new HashSet<E>();
		for(E e:s1) {
			if(!s2.contains(e)) {
				difference.add(e);
			}
		}
		return difference;
	}
}
