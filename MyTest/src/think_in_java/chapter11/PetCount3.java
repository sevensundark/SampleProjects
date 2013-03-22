package think_in_java.chapter11;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class PetCount3 {
	public static void main(String[] args) {
		Vector pets = new Vector();
	    Class[] petTypes = {
	      // Class literals work in Java 1.1+ only:
	      Pet3.class,
	      Dog3.class,
	      Pug3.class,
	      Cat3.class,
	      Rodent3.class,
	      Gerbil3.class,
	      Hamster3.class,
	    };

		try {
			for (int i = 0; i < 15; i++) {
				// Offset by one to eliminate Pet.class:
				int rnd = 1 + (int) (Math.random() * (petTypes.length - 1));
				pets.addElement(petTypes[rnd].newInstance());
			}
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}

		Hashtable h = new Hashtable();
		for (int i = 0; i < petTypes.length; i++) {
			h.put(petTypes[i].toString(), new Counter3());
		}
		
		for (int i = 0; i < pets.size(); i++) {
			Object o = pets.elementAt(i);
			for (int j = 0; j < petTypes.length; j++) {
				// x.isInstance(y) means: whether y is an instance of x
				if (petTypes[j].isInstance(o)) {
					String key = petTypes[j].toString();
					((Counter3)h.get(key)).i++;
				}
			}
		}
		
		for (int i = 0; i < pets.size(); i++)
			System.out.println(pets.elementAt(i).getClass().toString());
		
		Enumeration keys = h.keys();
		while (keys.hasMoreElements()) {
			String nm = (String) keys.nextElement();
			Counter3 cnt = (Counter3) h.get(nm);
			System.out.println(nm.substring(nm.lastIndexOf('.') + 1)
					+ " quantity: " + cnt.i);
		}
	  
		
	}
}

class Pet3 {}
class Dog3 extends Pet3 {}
class Pug3 extends Dog3 {}
class Cat3 extends Pet3 {}
class Rodent3 extends Pet3 {}
class Gerbil3 extends Rodent3 {}
class Hamster3 extends Rodent3 {}

class Counter3 { int i; }

