import java.util.Random;

public class TestComplexMatrix {

	public static void main(String[] args) {
		//Create Complex arrays m1, m2
		Complex[][] m1 = new Complex[3][3];
		Complex[][] m2 = new Complex[3][3];
		
		//Fill m1, m2
		Random random = new Random();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				m1[i][j] = new Complex((double)random.nextInt(11)-5,(double)random.nextInt(11)-5);
				m2[i][j] = new Complex((double)random.nextInt(11)-5,(double)random.nextInt(11)-5);
			}
		}
		
		//Create an instance of ComplexMatrix
		ComplexMatrix complexMatrix = new ComplexMatrix();
		
		GenericMatrix.printResult(m1, m2, complexMatrix.addMatrix(m1, m2),  '+');
		GenericMatrix.printResult(m1, m2, complexMatrix.multiplyMatrix(m1, m2),  '*');
	}

}
