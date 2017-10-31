import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pendulum extends Application {

	@Override
	public void start(Stage primaryStage) {
		Circle pBall = new Circle(250, 250, 30);
		pBall.setFill(Color.GOLDENROD);
		Line pBar = new Line();
		pBar.setStartX(250);
		pBar.setStartY(50);
		pBar.endXProperty().bind(pBall.centerXProperty().add(pBall.translateXProperty()));
		pBar.endYProperty().bind(pBall.centerYProperty().add(pBall.translateYProperty()));
		pBar.setStroke(Color.GOLDENROD);
		pBar.setStrokeWidth(10);
		Arc path = new Arc(250, 50, 250, 250, 225, 90);
		path.setFill(Color.TRANSPARENT);
		Pane pane = new Pane();
		pane.getChildren().addAll(pBall, pBar);
		
		// Create a path transition for the ball
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(path);
		pt.setNode(pBall); 
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();
		pane.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.UP) {
				pt.setRate(pt.getRate() + 0.1);
			}else if(e.getCode() == KeyCode.DOWN) {
				pt.setRate(pt.getRate() > 0 ? pt.getRate() - 0.1 : 0);
			}else if(e.getCode() == KeyCode.S) {
				pt.pause();
			}else if(e.getCode() == KeyCode.R) {
				pt.play();
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Pendulum"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		pane.requestFocus();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
