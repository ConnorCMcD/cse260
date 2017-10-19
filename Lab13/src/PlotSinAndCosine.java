import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class PlotSinAndCosine extends Application {
	private static final int SCENE_LENGTH = 400;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Polyline sine = new Polyline();
		ObservableList<Double> sinList = sine.getPoints();
		for (int x = -170; x <= 170; x++) {
			sinList.add(x + 200.0);
			sinList.add(200 - (50 * Math.sin((x / 100.0) * 2 * Math.PI)));
		}
		sine.setStroke(Color.RED);
			
		Polyline cosine = new Polyline();
		ObservableList<Double> cosList = cosine.getPoints();
		for (int x = -170; x <= 170; x++) {
			cosList.add(x + 200.0);
			cosList.add(200 - (50 * Math.cos((x / 100.0) * 2 * Math.PI)));
		}
		cosine.setStroke(Color.BLUE);
		
		Line xAxis = new Line(0, SCENE_LENGTH/2, SCENE_LENGTH, 
				SCENE_LENGTH/2);
		Line yAxis = new Line(SCENE_LENGTH/2, 0, SCENE_LENGTH/2, 
				SCENE_LENGTH);

		Pane pane = new Pane();
		pane.getChildren().add(sine);
		pane.getChildren().add(cosine);
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
