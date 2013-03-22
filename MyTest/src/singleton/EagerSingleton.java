package singleton;

public class EagerSingleton {
	private static final EagerSingleton mInstantce = new EagerSingleton();
	
	private EagerSingleton() {
		System.out.println("EagerSingleton---Myself is be instanted!!!");
	}
	
	public static EagerSingleton getInstance() {
		return mInstantce;
	}
}
