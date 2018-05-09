package myTreadPool;

public class Matrix {
	int dimention;
	int[][] myMatrix;
		
	public Matrix(int i) {
		this.dimention = i;
		this.myMatrix = new int[dimention][dimention];
	}
	
	public int getIndex(int i, int j) {
		return myMatrix[i][j];
	}
	
	public void setIndex(int i, int j, int toSet) {
		myMatrix[i][j] = toSet;
	}
	
	public int getDimention() {
		return this.dimention;
	}
	
	public int[][] getMyMatrix(){
		return this.myMatrix;
	}
}
