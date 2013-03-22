package think_in_java.chapter8;

import java.util.Hashtable;

public class SpringDetector {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		for (int i = 0; i < 10; i++)
			ht.put(new Groundhog(i), new Prediction());
		System.out.println("ht = " + ht + "\n");
		System.out.println("Looking up prediction for groundhog #3:");
		Groundhog gh = new Groundhog(3);
		if (ht.containsKey(gh))
			System.out.println((Prediction) ht.get(gh));
	}

}

class Groundhog {
	int ghNumber;

	Groundhog(int n) {
		ghNumber = n;
	}
	
	public int hashCode() {
		return ghNumber;
	}
	
	public boolean equals(Object o) {
		return ((Groundhog)o).ghNumber == this.ghNumber;
	}
}

class Prediction {
	boolean shadow = Math.random() > 0.5;

	public String toString() {
		if (shadow)
			return "Six more weeks of Winter!";
		else
			return "Early Spring!";
	}
}
