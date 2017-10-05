
public class MyPoint {
	private double x,y;
	public MyPoint() {
		this(0,0);
	}
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double distance(MyPoint p) {
		return this.distance(p.getX(), p.getY());
	}
	public double distance(double x2, double y2) {
		return Math.sqrt(Math.pow((x-x2),2) + Math.pow((y-y2),2));
	}
}
