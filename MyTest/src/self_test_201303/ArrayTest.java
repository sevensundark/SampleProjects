package self_test_201303;

public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 128;
        int j = 128;
        System.out.println(i == j);

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

        Integer c = -128;
        Integer d = -128;
        System.out.println(c == d);

        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f);

        
//		int x[][] = new int[][0];
		int y[][] = { { 1, 2 }, { 1 } };
		String z[][] = new String[0][];
		String z1[][] = { { "1", "2", }, { "yes", "no" }, { "thank" } };

        
	}

}
