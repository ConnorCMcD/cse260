
public class Complex extends Number{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2480349184932717953L;
	private double real,imag;
	public Complex(double a, double b) {
		real = a;
		imag = b;
	}
	public Complex(double a) {
		this(a, 0.0);
	}
	public Complex() {
		this(0.0, 0.0);
	}
	public Complex add(Complex n) {
		double a = real + n.getRealPart();
		double b = imag + n.getImaginaryPart();
		return new Complex(a,b);
	}
	public Complex subtract(Complex n) {
		double a = real - n.getRealPart();
		double b = imag - n.getImaginaryPart();
		return new Complex(a,b);
	}
	public Complex multiply(Complex n) {
		double a = (real*n.getRealPart())-(imag*n.getImaginaryPart());
		double b = (imag*n.getRealPart())+(real*n.getImaginaryPart());
		return new Complex(a,b);
	}
	public Complex divide(Complex n) {
		double a1 = (real*n.getRealPart())+(imag*n.getImaginaryPart());
		double c = (2*n.getRealPart())+(2*n.getImaginaryPart());
		double a = a1/c;
		double b1 = (imag*n.getRealPart())-(real*n.getImaginaryPart());
		double b = b1/c;
		return new Complex(a,b);
	}
	public double getRealPart() {
		return real;
	}
	public double getImaginaryPart() {
		return imag;
	}
	public String toString() {
		if(imag == 0.0) {
			return String.format("%.2f", real);
		}else if(real == 0.0) {
			return String.format("%.2fi", imag);
		}else {
		return String.format("%.2f + %.2fi", real, imag);
		}
	}
	@Override
	public double doubleValue() {
		return real;
	}
	@Override
	public float floatValue() {
		return (float)real;
	}
	@Override
	public int intValue() {
		return (int)real;
	}
	@Override
	public long longValue() {
		return (long)real;
	}
}
