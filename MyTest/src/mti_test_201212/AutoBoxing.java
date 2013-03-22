package mti_test_201212;

import java.util.Properties;

public class AutoBoxing {
	public static void main(String args[]) {
		Integer i = Integer.valueOf(5);
		
		test1();
	}
	
	
	static void test1() {
		int i = 128;  
        int j = 128;  
        System.out.println(i==j);  
          
        Integer a = 126;  
        Integer b = 126;  
        System.out.println(a==b);  
  
        Integer one = 128;  
        Integer two = 128;  
        System.out.println(one == two);  
	}
	
	static void test2() {
		Properties props = System.getProperties();
        String integerCacheHighPropValue =
            (String)props.remove("java.lang.Integer.IntegerCache.high");
        
        System.out.println(integerCacheHighPropValue);
        
        if (integerCacheHighPropValue != null)
            System.setProperties(props);
	}
}
