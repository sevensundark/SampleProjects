package JVM;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton sin = Singleton.getInstance();
		System.out.println("count1 = " + sin.counter1);
		System.out.println("count2 = " + sin.counter2);
	}
}

class Singleton {
	private static Singleton singleton = new Singleton();
	public static int counter1;
	public static int counter2 = 0;
	
	private Singleton() {
		counter1++;
		counter2++;
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
}