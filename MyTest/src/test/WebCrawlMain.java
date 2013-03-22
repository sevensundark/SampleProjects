package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebCrawlMain {

	private static String URL = "http://www.ctrip.com/?utm_source=baidu&utm_medium=cpc&utm_campaign=baidu81&campaign=CHNbaidu81&adid=index&gclid=&isctrip=T";
	
	public static void main(String[] args) {
		WebPageSearch wps = new WebPageSearch();
		System.out.println(wps.getPageData(URL, null));
	}
	
}

class WebPageSearch {
	public String getPageData(String url, String postData) {
		String content = null;
		try {
			URL dUrl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) dUrl.openConnection();

			byte d[] = new byte[4];
			String line;
			InputStream is = con.getInputStream();
			StringBuffer stringBuffer = new StringBuffer();
			Reader reader = new InputStreamReader(is, "GBK");

			// 增加缓冲功能
			BufferedReader bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line + "\n");
			}
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			content = stringBuffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return content;
	}
}