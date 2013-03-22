package mti_test_201209;

public class TestStringObjEquals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "the test";
		String s2 = "the test";
		
		String s3 = "the ";
		System.out.println(s3.hashCode());
		s3 = s3 + "test";
		System.out.println(s3.hashCode());
		
		System.out.println(s1 == s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s1 == s3);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
		String s4 = "t";
		System.out.println(s4.hashCode());
		s4 = s4 + "he";
		System.out.println(s4.hashCode());
		s4 = s4 + " test";
		System.out.println(s4.hashCode());
	}

}
