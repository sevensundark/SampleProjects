package java_knowledge;

public class String_StringBuffer_StringBuild {

	public static void main(String[] args) {
		use_stringBuild();
	}

	private static void use_string() {
		String str = "it's String.";
		String strC = new String("this is string class");
		System.out.println(str);
	}

	private static void use_stringBuffer() {
		StringBuffer strBuf = new StringBuffer("I am");
		strBuf.append(" the stringBuffer!");
		System.out.println(strBuf);
		System.out.println(strBuf.toString());
		strBuf.insert(4, " test");
		System.out.println(strBuf.toString());
//		strBuf.insert(5, "test");
	}
	
	private static void use_stringBuild() {
		StringBuilder strBuilder = new StringBuilder();
		System.out.println("init length: " + strBuilder.length());
		strBuilder.append("This is ");
		System.out.println(strBuilder.toString());
		strBuilder.append("stringBuilder!!");
		System.out.println(strBuilder.toString());
		strBuilder.insert(4, "TEST");
		System.out.println(strBuilder.toString());
	}
}
