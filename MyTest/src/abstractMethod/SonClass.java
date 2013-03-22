package abstractMethod;

public class SonClass extends DadClass {
	public void doit() {
		super.doit();
	}
	
	@Override
	protected String outStr() {
		return "son";
	}
}
