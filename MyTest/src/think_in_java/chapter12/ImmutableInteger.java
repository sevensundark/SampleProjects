package think_in_java.chapter12;

import java.util.Vector;

public class ImmutableInteger {
	public static void main(String[] args) {
		Vector v = new Vector();
		for (int i = 0; i < 10; i++)
			v.addElement(new IntValue(i));
		System.out.println(v);
		for (int i = 0; i < v.size(); i++)
			((IntValue) v.elementAt(i)).n++;
		System.out.println(v);

	}

}

class IntValue {
	int n;

	IntValue(int x) {
		n = x;
	}

	public String toString() {
		return Integer.toString(n);
	}
}
