package seasar2.aop;

/**
 * Aopの対象のコンポーネント
 */
public class AopOriginalServiceImpl implements AopOriginalService {

	/**
     * 処理対象のメソッドチェック.
     *
     * @param arg 引数
     * @throws Exception 例外
     */
	@Override
	public void aopOrginalCheck(boolean arg) throws Exception {
		System.out.println("処理を実行しますー");
        if (arg) {
            System.out.println("引数がtrueのとき10秒処理を待ちます");
            Thread.sleep(10000);
        }
        System.out.println("処理が終わりました");
	}

}
