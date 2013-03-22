package seasar2.aop;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

/**
 * AopをかけたServiceクラスを呼び出すMainクラス。
 *
 */
public class AopOriginalMain {

	// 設定ファイルのPath
    private static final String PATH = "seasar2/aop/aop_orijinal.dicon";

	
	public static void main(String[] args) {
		// 設定ファイルを読み込む.
		SingletonS2ContainerFactory.setConfigPath(PATH);
		
		// 初期化する.
		SingletonS2ContainerFactory.init();
		
		// コンテナを取得する.
		S2Container container = SingletonS2ContainerFactory.getContainer();

		// 対象のコンポーネントを取得する
		AopOriginalService aos = (AopOriginalService) container.getComponent(AopOriginalService.class);
		
		// サービスの実行
		try {
			// 10秒待つ処理をしません
			aos.aopOrginalCheck(false);

			// 10秒待つ処理をします.
			aos.aopOrginalCheck(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 使用したコンポーネントを廃棄する.
		container.destroy();

		
	}

}
