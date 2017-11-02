import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficLights extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle lightBox = new Rectangle(20, 15, 60, 170);
		lightBox.setFill(Color.BLACK);
		Circle rLight = new Circle(50, 45, 25);
		rLight.setStroke(Color.RED);
		rLight.setFill(Color.TRANSPARENT);
		Circle yLight = new Circle(50, 100, 25);
		yLight.setStroke(Color.YELLOW);
		yLight.setFill(Color.TRANSPARENT);
		Circle gLight = new Circle(50, 155, 25);
		gLight.setStroke(Color.GREEN);
		gLight.setFill(Color.TRANSPARENT);
		Pane pane = new Pane();
		pane.getChildren().addAll(lightBox, rLight, yLight, gLight);
		
		VBox lightSelect = new VBox(20);
		lightSelect.setAlignment(Pos.CENTER);
		RadioButton rbR = new RadioButton("Red");
		RadioButton rbY = new RadioButton("Yellow");
		RadioButton rbG = new RadioButton("Green");
		lightSelect.getChildren().addAll(rbR, rbY, rbG);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(lightSelect);
		borderPane.setCenter(pane);
		ToggleGroup group = new ToggleGroup();
		rbR.setToggleGroup(group);
		rbY.setToggleGroup(group);
		rbG.setToggleGroup(group);
		
		rbR.setOnAction(e -> {
			if(rbR.isSelected()) {
				rLight.setFill(Color.RED);
				yLight.setFill(Color.TRANSPARENT);
				gLight.setFill(Color.TRANSPARENT);
			}
		});
		
		rbY.setOnAction(e -> {
			if(rbY.isSelected()) {
				rLight.setFill(Color.TRANSPARENT);
				yLight.setFill(Color.YELLOW);
				gLight.setFill(Color.TRANSPARENT);
			}
		});
		
		rbG.setOnAction(e -> {
			if(rbG.isSelected()) {
				rLight.setFill(Color.TRANSPARENT);
				yLight.setFill(Color.TRANSPARENT);
				gLight.setFill(Color.GREEN);
			}
		});
		
		Scene scene = new Scene(borderPane, 150, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
