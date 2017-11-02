import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Histogram extends Pane {
	private int[] counts = new int[26];
	private double maxCount = 0;
	
	public void setCounts(int[] counts) {
		if(counts.length != this.counts.length) {
			System.out.println("Array does not have 26 entries");
			return;
		}
		maxCount = 0;
		for(int i=0; i<counts.length; i++) {
			this.counts[i] = counts[i];
			if(counts[i]>maxCount) {
				maxCount = counts[i];
			}
		}
	}
	
	public void display(double width, double height) {
		double barWidth = (width - 20)/26;
		for(int i=0; i<counts.length; i++) {
			Rectangle bar = new Rectangle();
			bar.setWidth(barWidth);
			bar.setHeight((height-20)*(((double)counts[i])/maxCount));
			bar.setX(((i+1)*barWidth) + 10);
			bar.setY(height - 10 - bar.getHeight());
			char c = (char) ('A' + i);
			Text label = new Text(bar.getX(), height-10, ""+c);
			this.getChildren().addAll(bar, label);
		}
	}
}
