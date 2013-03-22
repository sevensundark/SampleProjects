package self_test_201303;

public class TestException {

	public static void main(String[] args) {
		test(1);
		test(0);
	}

	public static int test(int param) {
		try {
			int result = 100 / param;
			return result;
		} catch (Exception e) {
			System.out.println("code1");
		} finally {
			System.out.println("code2");
		}
		System.out.println("code3");
		return 0;
	}

}
