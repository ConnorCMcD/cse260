import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LetterHistogram extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane filePane = new BorderPane();
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		filePane.setLeft(new Label("Enter file name/path:"));
		filePane.setCenter(tf);
		
		Histogram graphPane = new Histogram();
		graphPane.setCounts(new int[]{1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1});
		graphPane.display(520, 100);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(filePane);
		borderPane.setCenter(graphPane);
		Scene scene = new Scene(borderPane, 750, 500);
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
