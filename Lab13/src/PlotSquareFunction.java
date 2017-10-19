import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class PlotSquareFunction extends Application {
	private static final int SCENE_LENGTH = 400;

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create polyline
		Polyline polyline = new Polyline();
		ObservableList<Double> list = polyline.getPoints();
		double scaleFactor = 0.0125;
		for (int x = -100; x <= 100; x++) {
			list.add(x + 200.0);
			list.add((SCENE_LENGTH/2) - (scaleFactor * x * x));
		}
		polyline.setStroke(Color.RED);
		
		Line xAxis = new Line(0, SCENE_LENGTH/2, SCENE_LENGTH, 
				SCENE_LENGTH/2);
		Line yAxis = new Line(SCENE_LENGTH/2, 0, SCENE_LENGTH/2, 
				SCENE_LENGTH);

		Pane pane = new Pane();
		pane.getChildren().add(polyline);
		pane.getChildren().add(xAxis);
		pane.getChildren().add(yAxis);
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, SCENE_LENGTH, SCENE_LENGTH);
		primaryStage.setTitle("Square Function"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		launch(args);
	}
}
