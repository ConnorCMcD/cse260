import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BouncingBall extends Application {
	private Random random = new Random();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Create a pane to hold the ball
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 500, 500);
		for(int i=0; i<100; i++) {
			Circle ball = new Circle(random.nextInt(301)+100, 
					random.nextInt(301)+100, 10);
			pane.getChildren().add(ball);
			BallThread bt = new BallThread(ball, pane);
			bt.start();
		}
		// Create a scene and place it in the stage
		primaryStage.setTitle("Bouncing Ball"); // Set the stage title
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
class BallThread extends Thread{
	private Random random = new Random();
	private Pane pane;
	private Circle ball;
	private double ballVX, ballVY;
	private int rgb[] = {255, 0, 0};
	
	public BallThread(Circle ball, Pane pane) {
		this.ball = ball;
		this.pane = pane;
		ball.setStroke(Color.rgb(rgb[0], rgb[1], rgb[2]));
		ball.setFill(Color.rgb(rgb[0], rgb[1], rgb[2]));
		ballVX = random.nextDouble()*20 - 10;
		ballVY = random.nextDouble()*20 - 10;
	}
	
	public void run() {
		while(true) {
			Platform.runLater(() -> update());
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				//squelch
			}
		}
	}
	
	private void update() {
		if(rgb[0] == 255 && rgb[1] < 255) {
			if(rgb[2] > 0) {
				rgb[2]--;
			}else {
				rgb[1]++;
			}
		}else if(rgb[1] == 255 && rgb[2] < 255) {
			if(rgb[0] > 0) {
				rgb[0]--;
			}else {
				rgb[2]++;
			}
		}else {
			if(rgb[1] > 0) {
				rgb[1]--;
			}else {
				rgb[0]++;
			}
		}
		ball.setStroke(Color.rgb(rgb[0], rgb[1], rgb[2]));
		ball.setFill(Color.rgb(rgb[0], rgb[1], rgb[2]));
		ball.setCenterX(ball.getCenterX() + ballVX);
		if(ball.getCenterX() - ball.getRadius() < 0) {
			ball.setCenterX(ball.getRadius());
			ballVX = -1 * ballVX;
		}else if(ball.getCenterX() + ball.getRadius() > pane.getWidth()) {
			ball.setCenterX(pane.getWidth() - ball.getRadius());
			ballVX = -1 * ballVX;
		}
		ball.setCenterY(ball.getCenterY() + ballVY);
		if(ball.getCenterY() - ball.getRadius() < 0) {
			ball.setCenterY(ball.getRadius());
			ballVY = -1 * ballVY;
		}else if(ball.getCenterY() + ball.getRadius() > pane.getHeight()) {
			ball.setCenterY(pane.getHeight() - ball.getRadius());
			ballVY = -1 * ballVY;
		}
	}
	
}
