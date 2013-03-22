package Iterator.a_sample;

import java.util.Vector;

public abstract class Purchase {
	private Vector elements = new Vector(5);
	
	public abstract Iterator createIterator();
	
	public void append(Object anObj) {
		elements.add(anObj);
	}
	
	public void remove(Object anObj) {
		elements.removeElement(anObj);
	}
	
	public Object currentItem(int n) {
		return elements.elementAt(n);
	}
	
	public int count() {
		return elements.size();
	}
}
