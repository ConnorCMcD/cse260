import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TrimStringsInList {
	
	public static List<String> trimStrings(List<String> list) {
		ArrayList<String> alist = new ArrayList<String>(list);
		ListIterator<String> lit = alist.listIterator();
		while(lit.hasNext()) {
			String s = lit.next();
			lit.remove();
			lit.add(s.trim());
		}
		return alist;
	}
}
