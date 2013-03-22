package singleton;

public class RegSingletonChild extends RegSingleton {
	public RegSingletonChild() {
		
	}
	
	static public RegSingletonChild getInstance() {
		return (RegSingletonChild)RegSingleton.getInstance("singleton.RegSingletonChild");
	}
	
	public String about() {
		return "Hello, I am RegSingletonChild.";
	}
}
