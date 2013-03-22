package seasar2.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.container.ComponentDef;

/**
 * 対象のコンポーネントにAOPとしてかける例外処理クラス.
 */
public class AopOriginalSample extends AbstractInterceptor {

	/**
     * 処理の開始と終了時にログを出力、終了時に処理時間を計測するインターセプター
     *
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		ComponentDef tempName = getComponentDef(invocation);
		System.out.println(tempName.getClass().getName());
		System.out.println(tempName.getComponentName());
		System.out.println(tempName.getComponentClass().getName());
		
		// 対象のクラス
		String actionName = getTargetClass(invocation).getName();
		
		// 対象のメソッド
		String methodName = invocation.getMethod().getName();
		
		// メソッドの引数
        Object[] obList = invocation.getArguments();
        StringBuilder argSb = new StringBuilder();
        if (obList != null && obList.length > 0) {
            for (int i = 0; i < obList.length; i++) {
                if (i > 0) {
                    argSb.append(",");
                }
                argSb.append(obList[i]);
            }
        }

        // スタートログを追加
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date startDate = new Date();
		long startLong = System.currentTimeMillis();
		System.out.println("start : " + sdf.format(startDate) + " : "
				+ actionName + "#" + methodName + "(" + argSb + ")");

		try {
			invocation.proceed();
		} finally {
			// 終了ログを追加
			Date endDate = new Date();
            long endLong = System.currentTimeMillis();
            System.out.println("end : " + sdf.format(endDate) + " : "
                    + actionName + "#" + methodName + "(" + argSb + ")"
                    + " 処理時間 : " + (endLong - startLong) / 1000 + " 秒");

		}
		
		return null;
	}
	
}
