package myTreadPool;

import java.util.Random;

public class initTask extends Task{

	Matrix matrix;
	int dimention;

	public initTask(int n, Matrix a, int dimention) {
		super(n);
		this.dimention = dimention;
		this.matrix = a; //by reference
	}
	
	public Matrix getMatrix() {
		return this.matrix;
	}
	
	public void run() {
		for(int i = 0; i < this.dimention-1; i++){
			for(int j = 0; j < this.dimention-1; j++) {
				Random rand = new Random();
				int temp1 = rand.nextInt(11);
				matrix.setIndex(i, j, temp1);
			}
		}
	}
	
	
}	

