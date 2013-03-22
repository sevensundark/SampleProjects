package think_in_java.chapter7.innerscopes;

public class Parcel6 {
	public Contents cont() {
		return new Contents() {
			private int i = 11;

			public int value() {
				return i;
			}
		}; // Semicolon required in this case
	}

	public static void main(String[] args) {
		Parcel6 p = new Parcel6();
		Contents c = p.cont();
	}
}
