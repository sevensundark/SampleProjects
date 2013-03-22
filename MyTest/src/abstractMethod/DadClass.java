package abstractMethod;

public class DadClass {
	public void doit() {
		System.out.println(outStr());
	}
	
	protected String outStr() {
		return "dad";
	}
}
