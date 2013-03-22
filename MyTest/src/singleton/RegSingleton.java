package singleton;

import java.util.HashMap;

public class RegSingleton {
	static private HashMap mRegistry = new HashMap();
	
	static {
		RegSingleton x = new RegSingleton();
		mRegistry.put(x.getClass().getName(), x);
	}
	
	protected RegSingleton() {
		System.out.println("RegSingleton---Myself is be instanced!!!");
	}
	
	static public RegSingleton getInstance(String name) {
		if (name == null) {
			name = "singleton.RegSingleton";
		}
		
		if (mRegistry.get(name) == null) {
			try {
				mRegistry.put(name, Class.forName(name).newInstance());
			} catch(Exception e) {
				System.out.println("Error happened.");
			}
		}
		return (RegSingleton)(mRegistry.get(name));
	}
	
	public String about() {
		return "Hello, I am RegSingleton.";
	}
}
