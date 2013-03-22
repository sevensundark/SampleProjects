package think_in_java.init_setvalue;

public class OrderOfInitialization {
	public static void main(String[] args) {
	    Card t = new Card();
	    t.f(); // Shows that construction is done
	  }
}

class Tag {
	Tag(int marker) {
		System.out.println("Tag(" + marker + ")");
	}
}

class Card {
	Tag t1 = new Tag(1); // Before constructor

	Card() {
		// Indicate we're in the constructor:
		System.out.println("Card()");
		t3 = new Tag(33); // Re-initialize t3
	}

	Tag t2 = new Tag(2); // After constructor

	void f() {
		System.out.println("f()");
	}

	static Tag t3 = new Tag(3); // At end
}
