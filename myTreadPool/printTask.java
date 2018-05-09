package myTreadPool;

public class printTask extends Task{

	int [][] matrix;
	
	public printTask(int n, int[][] a) {
		super(n);
		this.matrix = a;
	}
	
	public void run() {
		for(int i = 0; i < matrix[0].length-1; i++){
		      for(int j = 0; j < matrix[0].length-1; j++){
		        System.out.print(matrix[i][j] + " ");
		      }
		      System.out.println();
		}
	}
}
