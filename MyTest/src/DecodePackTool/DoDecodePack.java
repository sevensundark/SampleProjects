package DecodePackTool;

import java.io.File;
import java.util.List;

public class DoDecodePack {

	private static String RES_DIR = "E:/test_decode/res";
	
	private static String TARGET_DIR = "E:/test_decode/target";
	
	private static String TEM_DIR_RES = "E:/test_decode/tem/res";
	
	private static String TEM_DIR_TARGET = "E:/test_decode/tem/target";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<File> resFiles = FileUtil.getFileList(RES_DIR);
			for (File file : resFiles) {
				String fNm = file.getName();
				String fNm_noend = fNm.substring(0, fNm.indexOf(".zip"));
//				File zipFile = new File(RES_DIR + File.separator + );
				if (fNm.endsWith(".zip")) {
//					String temDir = TEM_DIR + File.separator;
					FileUtil.unCompress(file, TEM_DIR_RES);
					
					List<File> fs = FileUtil.getFileList(TEM_DIR_RES + File.separator + fNm_noend);
					for (File f : fs) {
						String fn = f.getName();
						String fNmNoend = fn.substring(0, fn.indexOf(".png"));
						FileUtil.fileEncrypt(TEM_DIR_RES + File.separator + fNm_noend + File.separator + fn, TEM_DIR_TARGET + File.separator + fNmNoend);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("error occur!!");
		}
		
		System.out.println("do over!!");
	}

}
