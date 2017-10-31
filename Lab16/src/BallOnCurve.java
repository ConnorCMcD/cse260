import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BallOnCurve extends Application {

	@Override
	public void start(Stage primaryStage) {
		Polyline path = new Polyline();
		ObservableList<Double> pathList = path.getPoints();
		for (int x = -200; x <= 200; x++) {
			pathList.add(x + 200.0);
			pathList.add(200 - (50 * Math.sin((x / 100.0) * 2 * Math.PI)));
		}
		Circle ball = new Circle(0, 0, 10);
		ball.setFill(Color.BLUE);
		Pane pane = new Pane();
		pane.getChildren().addAll(ball, path);
		
		// Create a path transition for the ball
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(path);
		pt.setNode(ball); 
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
		pane.setOnMousePressed(e -> {
			if(pt.getStatus() == Animation.Status.RUNNING) {
				pt.pause();
			}else {
				pt.play();
			}
		});
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Ball On Curve"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
