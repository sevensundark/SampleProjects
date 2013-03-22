package think_in_java.chapter7;

public class Transmogrify {
	public static void main(String[] args) {
		Stage s = new Stage();
		s.go(); // Prints "HappyActor"
		s.change();
		s.go(); // Prints "SadActor"
		s.change();
		s.go(); 
		s.change();
		s.go(); 
		s.change();
		s.go(); 
		s.change();
		s.go(); 
		s.change();
		s.go(); 
	}

}

interface Actor {
	void act();
}

class HappyActor implements Actor {
	public void act() {
		System.out.println("HappyActor");
	}
}

class SadActor implements Actor {
	public void act() {
		System.out.println("SadActor");
	}
}

class Stage {
	Actor a = new HappyActor();

	void change() {
		if (a instanceof HappyActor) {
			a = new SadActor();
		} else {
			a = new HappyActor();
		}
		
	}

	void go() {
		a.act();
	}
}
