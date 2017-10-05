import java.util.PriorityQueue;

public class PrioritySetOperations {
	public static void main(String[] args) {
		PriorityQueue<String> q1 = new PriorityQueue<String>();
		q1.add("George");
		q1.add("Jim");
		q1.add("John");
		q1.add("Blake");
		q1.add("Kevin");
		q1.add("Michael");
		PriorityQueue<String> q2 = new PriorityQueue<String>();
		q2.add("George");
		q2.add("Katie");
		q2.add("Kevin");
		q2.add("Michelle");
		q2.add("Ryan");
		
		PriorityQueue<String> q1U2 = new PriorityQueue<String>();
		q1U2.addAll(q1);
		q1U2.removeAll(q2);
		q1U2.addAll(q2);
		System.out.println("Union: "+q1U2.toString());
		
		PriorityQueue<String> q1S2 = new PriorityQueue<String>();
		q1S2.addAll(q1);
		q1S2.removeAll(q2);
		System.out.println("1-2: "+q1S2.toString());
		
		PriorityQueue<String> q2S1 = new PriorityQueue<String>();
		q2S1.addAll(q2);
		q2S1.removeAll(q1);
		System.out.println("2-1: "+q2S1.toString());
		
		PriorityQueue<String> q1I2 = new PriorityQueue<String>();
		q1I2.addAll(q1);
		q1I2.retainAll(q2);
		System.out.println("Intersection: "+q1S2.toString());
	}

}
