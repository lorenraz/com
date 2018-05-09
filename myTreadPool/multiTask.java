package myTreadPool;

public class multiTask extends Task{
	
	Matrix matrixA;
	Matrix matrixB;
	Matrix matrixC;

	public multiTask(int n, Matrix a, Matrix b) {
		super(n);
		this.matrixA = a; 
		this.matrixB = b;
		this.matrixC = new Matrix(this.matrixA.getDimention()); 
	}
	
	public Matrix getMatrixC() {
		return this.matrixC;
	}

	public void run() {
		int length = this.matrixA.getDimention();
		int temp = 0;
		for (int i = 0; i < length ; i++) { 
            for (int j = 0; j < length; j++) { 
                for (int k = 0; k < length; k++) { 
                	temp = this.matrixC.getIndex(i, j);
                	temp = temp + this.matrixA.getIndex(i, k)*this.matrixB.getIndex(k, j);
                    this.matrixC.setIndex(i, j, temp);
                }
            }
        }
		//System.out.println();
	}

}


