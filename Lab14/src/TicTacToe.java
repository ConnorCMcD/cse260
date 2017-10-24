import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TicTacToe extends Application {
	private int playerTurn = 1;
	private int[][] board = new int[3][3];
	private GridPane boardPane = new GridPane();

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create board
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = 0;
				TTTPane b = new TTTPane(i,j);
				boardPane.add(b , j, i);
			}
		}
		
	}

	private void placeMark(int i, int j) {
		board[i][j] = playerTurn;
		boardPane.getChildren().
		playerTurn = playerTurn * -1;
		
	}

	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}

	class TTTPane extends StackPane {
		private int row, col;
		public TTTPane(int i, int j) {
			getChildren().add(new Button)
		}
	}
}
