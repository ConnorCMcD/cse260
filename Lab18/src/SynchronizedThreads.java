
public class SynchronizedThreads {
	private static final int NUMTHREADS = 1000;
	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	public static void main(String[] args) {
		SynchronizedThreads a = new SynchronizedThreads();
		for(int i=0; i<NUMTHREADS; i++) {
			GoodThread bt = new GoodThread(a);
			bt.start();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			/*SQUELCH*/
		}
		if(a.getCount() == NUMTHREADS) {
			System.out.println("All " +a.getCount()+ " threads accounted for!");
		}else {
			System.out.println("Only " +a.getCount()+ " of 1000 threads accounted for!");
		}
	}
}