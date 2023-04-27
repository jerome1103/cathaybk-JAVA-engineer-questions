package tw.com.cathaybk.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 依賴ValidUtil
*/
public class HttpclientUtil {
	static Logger logger = LoggerFactory.getLogger(HttpclientUtil.class);

	private static CloseableHttpClient httpclient = HttpClients.createDefault();
	private static HttpGet httpGet;

//	private static HttpGet httpPost;
	/*
	 * 對目標URL發送GET請求
	 */
	public static JSONObject httpGet(String url) throws Exception {
		logger.debug("Validating URL...");
		if (ValidUtil.urlValid(url) == false) {
			throw new Exception("Invalid URL!!!");
		}
		logger.debug("Prepare to send http GET request to " + url);
		httpGet = new HttpGet(url);
		// AutoCloseable自動進行Close
		try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
			JSONObject jsonResult = null;
			// 取狀態碼
			int statusCode = response.getStatusLine().getStatusCode();
			// 取內容
			HttpEntity entity = response.getEntity();
			// 200
			if (statusCode == HttpStatus.SC_OK) {
				logger.debug("Http Status:" + statusCode + ",Successfully obtained the return value.");
				String strResult = EntityUtils.toString(entity);
				jsonResult = new JSONObject(strResult);
			} else {
				logger.error("Http Status:" + statusCode + ",Can't get return value.");
			}
			// Apache官方建議的操作
			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity);
			return jsonResult;
		}
	}
}
