package tw.com.cathaybk.util;

import java.net.URL;

public class ValidUtil {
	/*
	 * 檢查URL網址正確性 
	*/
	public static boolean urlValid(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
