import java.util.HashSet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BoundingRectangle extends Application {
	private Pane pane = new Pane();
	private Rectangle rectangle = new Rectangle();
	private HashSet<Circle> circles = new HashSet<Circle>();

	@Override
	public void start(Stage primaryStage) {
		rectangle.setVisible(false);
		rectangle.setFill(Color.TRANSPARENT);
		pane.getChildren().add(rectangle);
		pane.setOnMouseClicked(e -> {
			if(!e.isShiftDown()) {
				Circle c = new Circle(e.getX(), e.getY(), 10);
				circles.add(c);
				pane.getChildren().add(c);
				updateRectangle(c);
			}
			for(Circle c:circles) {
				c.setOnMouseClicked(e2 ->{
					if(e.isShiftDown()) {
						circles.remove(c);
						pane.getChildren().remove(c);
						rectangle.setVisible(false);
						for(Circle c2:circles) {
							updateRectangle(c2);
						}
					}
				});
			}
		});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		scene.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.ENTER) {
				for(Circle c:circles) {
					pane.getChildren().remove(c);
				}
				circles.clear();
				rectangle.setVisible(false);
			}
		});
		primaryStage.setTitle("Bounding Rectangle"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	private void updateRectangle(Circle c) {
		if(rectangle.isVisible()) {
			if(c.getCenterX()-10 < rectangle.getX()) {
				rectangle.setWidth(rectangle.getX() + 
						rectangle.getWidth() - c.getCenterX() + 10);
				rectangle.setX(c.getCenterX()-10);
			}
			if(c.getCenterY()-10 < rectangle.getY()) {
				rectangle.setHeight(rectangle.getY() + 
						rectangle.getHeight() - c.getCenterY() + 10);
				rectangle.setY(c.getCenterY()-10);
			}
			if(c.getCenterX()+10 > rectangle.getX()+rectangle.getWidth()) {
				rectangle.setWidth(c.getCenterX() + 10 - rectangle.getX());
			}
			if(c.getCenterY()+10 > rectangle.getY()+rectangle.getHeight()) {
				rectangle.setHeight(c.getCenterY() + 10 - rectangle.getY());
			}
		}else {
			rectangle.setX(c.getCenterX()-10);
			rectangle.setY(c.getCenterY()-10);
			rectangle.setWidth(20);
			rectangle.setHeight(20);
			rectangle.setStroke(Color.BLUE);
			rectangle.setVisible(true);
		}
	}

	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}
}