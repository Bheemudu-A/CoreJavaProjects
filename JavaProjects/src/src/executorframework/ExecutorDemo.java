package src.executorframework;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	
	public static void main(String[] args) {
		
	//	ExecutorService e = Executors.newFixedThreadPool(3);
	//	ExecutorService e = Executors.newSingleThreadExecutor();
		ExecutorService e = Executors.newScheduledThreadPool(2);
		
		for(int i=0;i<5;i++) {
			e.execute(new MyRunnable());
		}
		e.shutdown();
		
		
		
		
	}

}
