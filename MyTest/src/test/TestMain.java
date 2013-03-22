package test;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        
        System.out.println("i1=i2\t" + (i1 == i2));
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));   
        
        String is = "dd";
        
        System.out.println();
        
        Double d1 = 1d;
        Double d2 = 1d;
        System.out.println("d1=d2\t" + (d1 == d2));
        
        
        float f1 = 1.123f;
        float f2 = 1.123f;
        System.out.println("f1=f2\t" + (f1 == f2));
        
        System.out.println();
        
        String a1 = "app";
        String a2 = "a" + "pp";
        System.out.println("a1=a2\t" + (a1 == a2));
        
        String a3 = "app";
        String t1 = "pp";
        String a4 = "a" + t1;
        System.out.println("a3=a4\t" + (a3 == a4));
        
        
	}

}
