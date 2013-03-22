package think_in_java.chapter11;

import java.util.Enumeration;
import java.util.Vector;

public class Shapes {

	public static void main(String[] args) {
//		Vector<Shape> s = new Vector<Shape>();
//		s.add(new Circle());
//		s.add(new Square());
//		s.add(new Triangle());
//		Enumeration<Shape> e = s.elements();
//		while (e.hasMoreElements()) {
//			e.nextElement().draw();
//		}
		
		Vector s = new Vector();
		s.add(new Circle());
		s.add(new Square());
		s.add(new Triangle());
		Enumeration e = s.elements();
		while (e.hasMoreElements()) {
			((Shape)e.nextElement()).draw();
		}
	}
	
}

interface Shape {
	void draw();
}

class Circle implements Shape {
	public void draw() {
		System.out.println("Circle.draw()");
	}
}

class Square implements Shape {
	public void draw() {
		System.out.println("Square.draw()");
	}
}

class Triangle implements Shape {
	public void draw() {
		System.out.println("Triangle.draw()");
	}
}
