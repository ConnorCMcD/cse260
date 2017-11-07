

public class BadThread extends Thread {
	private NonSynchronizedThreads a;
	
	public BadThread(NonSynchronizedThreads a) {
		this.a = a;
	}
	
	@Override
	public void run() {
		a.increment();
	}
}
