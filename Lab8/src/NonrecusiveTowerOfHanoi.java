import java.util.Stack;

public class NonrecusiveTowerOfHanoi {
	public static void moveDisks(int n){
		Stack<Integer> towerA = new Stack<Integer>();
		Stack<Integer> towerB = new Stack<Integer>();
		Stack<Integer> towerC = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			towerA.push(n-i);
		}
		int moves = 1;
		for(int i=0; i<n; i++) {
			moves = moves*2;
		}
		moves--;
		if(n%2 == 1) {
			for(int i=0; i<moves; i++) {
				if(i%3 == 0) {
					if(towerA.isEmpty()) {
						System.out.println("Move disk " + towerB.peek() +
								" from B to A.");
						towerA.push(towerB.pop());
					} else if(towerB.isEmpty()) {
						System.out.println("Move disk " + towerA.peek() +
								" from A to B.");
						towerB.push(towerA.pop());
					} else if(towerA.peek()<towerB.peek()) {
						System.out.println("Move disk " + towerA.peek() +
								" from A to B.");
						towerB.push(towerA.pop());
					} else {
						System.out.println("Move disk " + towerB.peek() +
								" from B to A.");
						towerA.push(towerB.pop());
					}
				} else if(i%3 == 1) {
					if(towerA.isEmpty()) {
						System.out.println("Move disk " + towerC.peek() +
								" from C to A.");
						towerA.push(towerC.pop());
					} else if(towerC.isEmpty()) {
						System.out.println("Move disk " + towerA.peek() +
								" from A to C.");
						towerC.push(towerA.pop());
					} else if(towerA.peek()<towerC.peek()) {
						System.out.println("Move disk " + towerA.peek() +
								" from A to C.");
						towerC.push(towerA.pop());
					} else {
						System.out.println("Move disk " + towerC.peek() +
								" from C to A.");
						towerA.push(towerC.pop());
					}
				} else {
					if(towerC.isEmpty()) {
						System.out.println("Move disk " + towerB.peek() +
								" from B to C.");
						towerC.push(towerB.pop());
					} else if(towerB.isEmpty()) {
						System.out.println("Move disk " + towerC.peek() +
								" from C to B.");
						towerB.push(towerC.pop());
					} else if(towerB.peek()<towerC.peek()) {
						System.out.println("Move disk " + towerB.peek() +
								" from B to C.");
						towerC.push(towerB.pop());
					} else {
						System.out.println("Move disk " + towerC.peek() +
								" from C to B.");
						towerB.push(towerC.pop());
					}
				}
			}
		} else {
			for(int i=0; i<moves; i++) {
				if(i%3 == 0) {
					if(towerA.isEmpty()) {
						System.out.println("Move disk " + towerC.peek() +
								" from C to A.");
						towerA.push(towerC.pop());
					} else if(towerC.isEmpty()) {
						System.out.println("Move disk " + towerA.peek() +
								" from A to C.");
						towerC.push(towerA.pop());
					} else if(towerA.peek()<towerC.peek()) {
						System.out.println("Move disk " + towerA.peek() +
								" from A to C.");
						towerC.push(towerA.pop());
					} else {
						System.out.println("Move disk " + towerC.peek() +
								" from C to A.");
						towerA.push(towerC.pop());
					}
				} else if(i%3 == 1) {
					if(towerA.isEmpty()) {
						System.out.println("Move disk " + towerB.peek() +
								" from B to A.");
						towerA.push(towerB.pop());
					} else if(towerB.isEmpty()) {
						System.out.println("Move disk " + towerA.peek() +
								" from A to B.");
						towerB.push(towerA.pop());
					} else if(towerA.peek()<towerB.peek()) {
						System.out.println("Move disk " + towerA.peek() +
								" from A to B.");
						towerC.push(towerA.pop());
					} else {
						System.out.println("Move disk " + towerB.peek() +
								" from C to A.");
						towerA.push(towerB.pop());
					}
				} else {
					if(towerC.isEmpty()) {
						System.out.println("Move disk " + towerB.peek() +
								" from B to C.");
						towerC.push(towerB.pop());
					} else if(towerB.isEmpty()) {
						System.out.println("Move disk " + towerC.peek() +
								" from C to B.");
						towerB.push(towerC.pop());
					} else if(towerB.peek()<towerC.peek()) {
						System.out.println("Move disk " + towerB.peek() +
								" from B to C.");
						towerC.push(towerB.pop());
					} else {
						System.out.println("Move disk " + towerC.peek() +
								" from C to B.");
						towerB.push(towerC.pop());
					}
				}
			}
		}
		/**
		if (n == 1) // Stopping condition
			System.out.println("Move disk " + n + " from " +
					fromTower + " to " + toTower);
		else {
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " +
					fromTower + " to " + toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
		*/
	}
}
