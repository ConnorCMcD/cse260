import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HandEyeCoordination extends Application {
	private static final int ROUNDS = 2;
	private static final int RADIUS = 10;
	private StackPane pane = new StackPane();
	private long startTime;
	private int clicked = 0;
	private Random random = new Random();

	@Override
	public void start(Stage primaryStage) {
		makeCircle();
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Bounding Rectangle"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void makeCircle() {
		Circle c = new Circle(random.nextInt(480)+RADIUS, 
				random.nextInt(480)+RADIUS,RADIUS);
		c.setOnMouseClicked(e -> {
			clicked++;
			pane.getChildren().remove(c);
			if(clicked >= ROUNDS) {
				endGame();
			}else {
				makeCircle();
			}
		});
		pane.getChildren().add(c);
	}

	private void endGame() {
		Text text = new Text("Time Taken: " + (System.currentTimeMillis()-startTime));
		text.setTextAlignment(TextAlignment.CENTER);
		text.setStroke(Color.BLACK);
		pane.getChildren().add(text);
	}

	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}
}
