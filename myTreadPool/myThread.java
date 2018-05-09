package myTreadPool;

import java.util.LinkedList;
import java.util.Scanner;


public class myThread { 
	
	  public static void main(String[] args)
	  {
	    Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("please choose the number of thresds you wish to add (2-20)");  //ask the user number of threads to add
		int threadsNum = reader.nextInt(); // Scans the next token of the input as an int.
	    while(true) {
	    	System.out.println("please choose the quantity of square matrices (more then 2)");  //ask the user number of square matrices
			int matricesNum = reader.nextInt();
		    
		    System.out.println("please choose the dimension of the square matrices (more then 1000)");  //ask the user number of square matrices
			int matricesDimension = reader.nextInt();
			
			//queue of matrices
			LinkedList<Matrix> matrixQueue = new LinkedList<Matrix>();
			for(int i = 0; i < matricesNum; i++) {
				Matrix mat = new Matrix(matricesDimension+1);
					matrixQueue.add(mat);
			}
		    //creating the threads
		    myThreadPool pool = new myThreadPool(threadsNum);
		    int taskNum = 1;
		    //add the tasks:
		    //initial tasks
		    for(int i = 0; i < matricesNum; i++) {
		    	Task task = new initTask(taskNum, matrixQueue.poll(), matricesDimension+1);
		    	taskNum++;
		    	pool.execute(task);
		    		matrixQueue.add(((initTask)task).getMatrix());
		   	}    
		    //multiple tasks
		    	 while(!matrixQueue.isEmpty()) {
		 	    	taskNum++;
		 	    	Matrix matA = matrixQueue.poll();
		 	    	if(matrixQueue.isEmpty()) {//this is the last matrix, break and go to print task
		 	    			matrixQueue.add(matA);	 	    		
		 	    		break;
		 	    	} 
		 	    	Matrix matB = matrixQueue.poll();
		 	    	Task task = new multiTask(taskNum, matA, matB);
		 	    	pool.execute(task);
		 	    	Matrix matC = ((multiTask) task).getMatrixC();
		 	    		matrixQueue.add(matC);	 	    	
		 	    }
		  //print task
		    Task task = new printTask(taskNum,matrixQueue.poll().getMyMatrix());
		    pool.execute(task);
	    }
		
	} 
	  
}
