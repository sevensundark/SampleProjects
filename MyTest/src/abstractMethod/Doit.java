package abstractMethod;

public class Doit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SonClass son = new SonClass();
		son.doit();
		
		String str = "123.asdf.vcwz";
		System.out.println(str.substring(str.lastIndexOf(".") + 1));
	}

}
