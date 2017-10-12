import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GuessCapitals {
	private static final String[] states = {"Alabama", "Alaska",
			"Arizona", "Arkansas", "California", "Colorado",
			"Connecticut", "Delaware", "Florida", "Georgia",
			"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
			"Kansas", "Kentucky", "Louisiana", "Maine", 
			"Maryland", "Massachusetts", "Michigan", "Minnesota",
			"Mississippi", "Missouri", "Montana", "Nebraska",
			"Nevada", "New Hampshire", "New Jersey", "New Mexico",
			"New York", "North Carolina", "North Dakota", "Ohio",
			"Oklahoma", "Oregan", "Pennsylvania", "Rhode Island",
			"South Carolina", "South Dakota", "Tennessee",
			"Texas", "Utah", "Vermont", "Virginia", "Washington",
			"West Virginia", "Wisconsin", "Wyoming"};
	private static final String[] capitals = {"Montgomery",
			"Juneau", "Phoenix", "Little Rock", "Sacramento", 
			"Denver", "Hartford", "Dover", "Tallahassee", 
			"Atlanta", "Honolulu", "Boise", "Springfield", 
			"Indianapolis", "Des Moines", "Topeka", "Frankfort",
			"Baton Rouge", "Augusta", "Annapolis", "Boston",
			"Lansing", "St. Paul", "Jackson", "Jefferson City",
			"Helena", "Lincoln", "Carson City", "Concord", 
			"Trenton", "Santa Fe", "Albany", "Raleigh", 
			"Bismarck", "Columbus", "Oklahoma City", "Salem", 
			"Harrisburg", "Providence", "Columbia", "Pierre", 
			"Nashville", "Austin", "Salt Lake City", "Montpelier", 
			"Richmond", "Olympia", "Charleston", "Madison", 
			"Cheyenne"};
	private static Scanner input = new Scanner(System.in);
	private static Random random = new Random();
	
	public static void main(String[] args) {
		HashMap<String, String> statecapitals = new HashMap<String, String>();
		for(int i=0; i<50; i++) {
			statecapitals.put(states[i], capitals[i]);
		}
		
		System.out.println("Guess the Capital! (Ctrl + Z to exit)");
		int score = 0, questions = 0;
		while(true) {
			String state = states[random.nextInt(50)];
			System.out.println("What is the capital of "+state+"?");
			if(!input.hasNextLine()) {
				System.out.println("Final score: "+score+"/"+questions);
				return;
			}
			questions++;
			if(statecapitals.get(state).equals(input.nextLine())) {
				score++;
				System.out.println("That is correct!");
			}else {
				System.out.println("That is incorrect.\nThe correct answer was "
						+statecapitals.get(state));
			}
			System.out.println("Score: "+score+"/"+questions+"\n");
		}
	}

}
