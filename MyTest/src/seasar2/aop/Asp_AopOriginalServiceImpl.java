package seasar2.aop;

/**
 * Aopの対象のコンポーネント
 */
public class Asp_AopOriginalServiceImpl implements Asp_AopOriginalService {


	@Override
	public void asp_aopOrginalStr(String str, int[] intArr) {
		System.out.println("Asp_AopOriginalService---asp_aopOrginalStr() is called");
		
		System.out.println("Asp_AopOriginalService:String---" + str);

		System.out.print("Asp_AopOriginalService:int[]---");
		
		for (int i : intArr) {
			System.out.print( i + ", ");
		}
	}

}
