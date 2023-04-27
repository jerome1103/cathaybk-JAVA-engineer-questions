package tw.com.cathaybk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyDateUtil {
	private static Logger logger = LoggerFactory.getLogger(MyDateUtil.class);

	// 將指定字串日期格式轉換成指定格式(預設時區)
	public static String dateFormatConverter(String date, String oldFormat, String newFormat) throws ParseException {
		return dateFormatConverter(date, oldFormat, newFormat, null);
	}

	// 將指定字串日期格式轉換成指定格式(指定時區)
	public static String dateFormatConverter(String date, String oldFormat, String newFormat, Locale lang)
			throws ParseException {
		if (lang == null) {
			logger.debug("Convert date using 'default' timezone.");
			SimpleDateFormat inputDateFormat = new SimpleDateFormat(oldFormat);
			SimpleDateFormat outputDateFormat = new SimpleDateFormat(newFormat);
			return outputDateFormat.format(inputDateFormat.parse(date));
		}
		logger.debug("Convert date using 'specified' time zone.");
		SimpleDateFormat inputDateFormat = new SimpleDateFormat(oldFormat, lang);
		SimpleDateFormat outputDateFormat = new SimpleDateFormat(newFormat, lang);
		return outputDateFormat.format(inputDateFormat.parse(date));
	}
}
