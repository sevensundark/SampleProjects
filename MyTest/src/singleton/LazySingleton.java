package singleton;

public class LazySingleton {
	private static LazySingleton mInstantce = null;
	
	private LazySingleton() {
		System.out.println("LazySingleton---Myself is be instanted!!!");
	}
	
	synchronized public static LazySingleton getInstance() {
		if (mInstantce == null) {
			mInstantce = new LazySingleton();
		}
		return mInstantce;
	}
}
