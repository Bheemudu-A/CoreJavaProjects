package src.executorframework;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread: "+Thread.currentThread().getName());
	}

	
	public void sampleMethod() {
		System.out.println("will it executes");
	}
	
}
