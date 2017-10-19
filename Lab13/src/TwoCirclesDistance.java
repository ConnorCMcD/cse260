import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class TwoCirclesDistance extends Application {
	private static final int CIRCLE_RADIUS = 15;
	private static final int SCENE_LENGTH = 200;
	private static final Random random = new Random();
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a circle and set its properties
		int c1X = random.nextInt(SCENE_LENGTH - 
				(2*CIRCLE_RADIUS))+CIRCLE_RADIUS;
		int c1Y = random.nextInt(SCENE_LENGTH - 
				(2*CIRCLE_RADIUS))+CIRCLE_RADIUS;
		int c2X = random.nextInt(SCENE_LENGTH - 
				(2*CIRCLE_RADIUS))+CIRCLE_RADIUS;
		int c2Y = random.nextInt(SCENE_LENGTH - 
				(2*CIRCLE_RADIUS))+CIRCLE_RADIUS;
				
		
		Circle c1 = new Circle();
		c1.setCenterX(c1X);
		c1.setCenterY(c1Y);
		c1.setRadius(CIRCLE_RADIUS);
		c1.setStroke(Color.BLACK);
		c1.setFill(Color.BLACK);
		
		Circle c2 = new Circle();
		c2.setCenterX(c2X);
		c2.setCenterY(c2Y);
		c2.setRadius(CIRCLE_RADIUS);
		c2.setStroke(Color.BLACK);
		c2.setFill(Color.BLACK);
		
		Line line = new Line(c1X, c1Y, c2X, c2Y);
		line.setStroke(Color.RED);
		double d = Math.sqrt(((c1X-c2X)*(c1X-c2X)) + 
				((c1Y-c2Y)*(c1Y-c2Y)));
		Text dist = new Text((c1X+c2X)/2, (c1Y+c2Y)/2, ""+d);
		dist.setFill(Color.RED);
		dist.setFont(Font.font("Courier", FontWeight.BOLD, 15));
		
		
		// Create a pane to hold the circle
		Pane pane = new Pane();
		pane.getChildren().add(c1);
		pane.getChildren().add(c2);
		pane.getChildren().add(line);
		pane.getChildren().add(dist);
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Two Circles"); // Set the stage title
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
