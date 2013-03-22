package think_in_java.chapter7;

public class HorrorShow {
	static void u(Monster b) {
		b.menace();
	}

	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}

	public static void main(String[] args) {
		DragonZilla if2 = new DragonZilla();
		u(if2);
		v(if2);
	}

}

interface Monster {
	int i = 0;
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	public void menace() {
	}

	public void destroy() {
	}
}

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}
