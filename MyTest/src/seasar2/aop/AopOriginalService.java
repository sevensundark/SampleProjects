package seasar2.aop;

/**
 * Aopの対象のコンポーネント
 */
public interface AopOriginalService {

	/**
     * サンプルチェック.
     * @param arg 引数
     * @return 戻り値
     * @throws Exception 例外
     * */
    public void aopOrginalCheck(boolean arg) throws Exception;
}
