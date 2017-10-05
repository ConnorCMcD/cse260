
public class MyInteger {
	private int n;
	public MyInteger(int n) {
		this.n = n;
	}
	public int getInt() {
		return n;
	}
	public boolean isEven() {
		return isEven(n);
	}
	public boolean isOdd() {
		return isOdd(n);
	}
	public boolean isPrime() {
		return isPrime(n);
	}
	public static boolean isEven(int n) {
		return (n%2 == 0);
	}
	public static boolean isOdd(int n) {
		return (n%2 == 1);
	}
	public static boolean isPrime(int n) {
		int i = 2;
		while(true) {
			if((n/i)*i == n) {
				return false;
			}
			i++;
			if(i > n/i) {
				return true;
			}
		}
	}
	public static boolean isEven(MyInteger num) {
		return num.isEven();
	}
	public static boolean isOdd(MyInteger num) {
		return num.isOdd();
	}
	public static boolean isPrime(MyInteger num) {
		return num.isPrime();
	}
	public boolean equals(int n) {
		return (n == this.n);
	}
	public boolean equals(MyInteger num) {
		return num.equals(this.n);
	}
	public static int parseInt(String num) {
		int x = 0;
		for(int i=0; i<num.length(); i++) {
			x = x*10;
			char c = num.charAt(i);
			if(c >= '0' && c <= '9') {
				x += c - 48;
			}else {
				System.out.println("Invalid String");
				return -1;
			}
		}
		return x;
	}
}
