
public class Collatz {
	public static int howManyCollatzIterations(int n) {
		int i = 0;
		while(true) {
			if(n == 1) {
				return i;
			}else if(n%2 == 0) {
				n = n/2;
			}else {
				n = (3 * n) + 1;
			}
		}
	}
}
