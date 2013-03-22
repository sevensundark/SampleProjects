package sort_algorithm;

public abstract class CommonClass {
	protected void doMain() {
		long start = System.nanoTime();
		
		doSort();
		
		long end = System.nanoTime();
		System.out.println("time = " + (end - start) / 1e9 + " seconds");
	}
	
	abstract void doSort();
}
