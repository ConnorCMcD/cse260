import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TwoRectangles extends Application {
	private Scanner input = new Scanner(System.in);

	@Override
	public void start(Stage primaryStage) {
		// Prompt user for inputs
		double r1X = 0, r1Y = 0, r1W = 0, r1H = 0, 
				r2X = 0, r2Y = 0, r2W = 0, r2H = 0;
		System.out.println("Input the requested infortmation for the rectangles."
				+ "\nFirst Rectangle:\nX-Coord of center");
		try {
			r1X = Double.parseDouble(input.nextLine());
		}catch(Exception e){
			System.out.println("Input not able to be read as double");
			input.close();
			return;
		}
		System.out.println("Y-Coord of center");
		try {
			r1Y = Double.parseDouble(input.nextLine());
		}catch(Exception e){
			System.out.println("Input not able to be read as double");
			input.close();
			return;
		}
		System.out.println("Width");
		try {
			r1W = Double.parseDouble(input.nextLine());
		}catch(Exception e){
			System.out.println("Input not able to be read as double");
			input.close();
			return;
		}
		System.out.println("Height");
		try {
			r1H = Double.parseDouble(input.nextLine());
		}catch(Exception e){
			System.out.println("Input not able to be read as double");
			input.close();
			return;
		}
		System.out.println("Second Rectangle:\nX-Coord of center");
		try {
			r2X = Double.parseDouble(input.nextLine());
		}catch(Exception e){
			System.out.println("Input not able to be read as double");
			input.close();
			return;
		}
		System.out.println("Y-Coord of center");
		try {
			r2Y = Double.parseDouble(input.nextLine());
		}catch(Exception e){
			System.out.println("Input not able to be read as double");
			input.close();
			return;
		}
		System.out.println("Width");
		try {
			r2W = Double.parseDouble(input.nextLine());
		}catch(Exception e){
			System.out.println("Input not able to be read as double");
			input.close();
			return;
		}
		System.out.println("Height");
		try {
			r2H = Double.parseDouble(input.nextLine());
		}catch(Exception e){
			System.out.println("Input not able to be read as double");
			input.close();
			return;
		}
		
		//Create rectangles and set properties
		Rectangle r1 = new Rectangle(r1X - (r1W/2), r1Y - (r1H/2), r1W, r1H);
		r1.setStroke(Color.BLACK);
		r1.setFill(Color.TRANSPARENT);
		Rectangle r2 = new Rectangle(r2X - (r2W/2), r2Y - (r2H/2), r1W, r2H);
		r2.setStroke(Color.BLACK);
		r2.setFill(Color.TRANSPARENT);
		
		//Check if rectangles overlap and create relevant text
		Text text = new Text();
		if((r1X == r2X) && (r1Y == r2Y) && (r1W == r2W) && (r1W == r2W)) {
			text.setText("Rectangle 1 and 2 are the same.");
		}else if((r1X - (r1W/2) <= r2X - (r2W/2)) && 
				(r1Y - (r1H/2) <= r2Y - (r2H/2)) && 
				(r1X + (r1W/2) >= r2X + (r2W/2)) && 
				(r1Y + (r1H/2) >= r2Y + (r2Y/2))) {
			text.setText("Rectangle 1 contains Rectangle 2.");
		}else if((r1X - (r1W/2) >= r2X - (r2W/2)) && 
				(r1Y - (r1H/2) >= r2Y - (r2H/2)) && 
				(r1X + (r1W/2) <= r2X + (r2W/2)) && 
				(r1Y + (r1H/2) <= r2Y + (r2Y/2))) {
			text.setText("Rectangle 2 contains Rectangle 1.");
		}else if((r1X - (r1W/2) <= r2X + (r2W/2)) && 
				(r1Y - (r1H/2) <= r2Y + (r2H/2)) && 
				(r1X + (r1W/2) >= r2X - (r2W/2)) && 
				(r1Y + (r1H/2) >= r2Y - (r2Y/2))) {
			text.setText("Rectangle 1 and 2 overlap.");
		}else {
			text.setText("Rectangle 1 and 2 do not overlap.");
		}
		text.setFill(Color.RED);
		text.setFont(Font.font("Courier", FontWeight.BOLD, 15));
		
		//Create pane to hold rectangles and text
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		Pane center = new Pane();
		Pane bottom = new Pane();
		center.getChildren().add(r1);
		center.getChildren().add(r2);
		bottom.getChildren().add(text);
		pane.setCenter(center);
		pane.setBottom(bottom);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Two Rectangles"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}
}
