package think_in_java.chapter11;

public class ToyTest {
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("think_in_java.chapter11.FancyToy");
		} catch (ClassNotFoundException e) {

		}
		
		printInfo(c);
		
		Class[] faces = c.getInterfaces();
		for (int i = 0; i < faces.length; i++) {
			printInfo(faces[i]);
		}
		
		Class cy = c.getSuperclass();
		Object o = null;
		try {
			o = cy.newInstance();
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
	    
		printInfo(o.getClass());

	}
	
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() + " is interface? ["
				+ cc.isInterface() + "]");
	}

}

interface HasBatteries {}
interface Waterproof {}
interface ShootsThings {}


class Toy {
	// Comment out the following default
	// constructor to see
	// NoSuchMethodError from (*1*)
	Toy() {
	}

	Toy(int i) {
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, ShootsThings {
	FancyToy() {
		super(1);
	}
}


