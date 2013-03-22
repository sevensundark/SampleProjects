package think_in_java.chapter7.innerscopes;

public class Parcel7 {
	public Wrapping wrap(int x) {
		// Base constructor call:
		return new Wrapping(x) {
			public int value() {
				return super.value() * 47;
			}
		}; // Semicolon required
	}

	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Wrapping w = p.wrap(10);
	}

}
