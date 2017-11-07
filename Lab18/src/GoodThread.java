
public class GoodThread extends Thread {
	private SynchronizedThreads a;
	
	public GoodThread(SynchronizedThreads a) {
		this.a = a;
	}
	
	@Override
	public void run() {
		a.increment();
	}
}
