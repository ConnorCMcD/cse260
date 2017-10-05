import java.util.Scanner;

public class TestLab8 {
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Input expression to evaluate");
		System.out.println(EvaluateExpression.evaluateExpression(input.nextLine()));
		System.out.println("\nTower of Hanoi with 3 Disks:");
		NonrecusiveTowerOfHanoi.moveDisks(3);
	}
}
