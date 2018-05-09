package myTreadPool;


import java.util.concurrent.LinkedBlockingQueue;

public class myThreadPool {
	 private int nThreads;
	 private PoolWorker[] threads;
	 private LinkedBlockingQueue<Runnable> queue;
	 private LinkedBlockingQueue<Runnable> complete;

	    public myThreadPool(int nThreads) {
	        this.setnThreads(nThreads);
	        queue = new LinkedBlockingQueue<Runnable>();
	        complete = new LinkedBlockingQueue<Runnable>();
	        threads = new PoolWorker[nThreads];

	        for (int i = 0; i < nThreads; i++) {
	            threads[i] = new PoolWorker();
	            threads[i].start();
	        }
	    }

	    public void execute(Runnable task) {
	        synchronized (queue) {
	            queue.add(task);
	            queue.notify();
	        }
	    }
	    
	    public void addToComplete(Runnable task) {
	    	synchronized (queue) {
	            complete.add(task);
	        }
	    }

	    public int getnThreads() {
			return nThreads;
		}

		public void setnThreads(int nThreads) {
			this.nThreads = nThreads;
		}

		private class PoolWorker extends Thread {
	        public void run() {
	            Runnable task;

	            while(true) {
	                synchronized(queue) {
	                    while(queue.isEmpty()) {
	                        try {
	                            queue.wait();
	                        } catch (InterruptedException e) {
	                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
	                        }
	                    }
	                    task = queue.poll(); 
	                }
	                try {
	                    task.run();
	                    addToComplete(task); ///////////??????????????????
	                } catch (RuntimeException e) {
	                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
	                }
	            }
	        }
	    }
}



