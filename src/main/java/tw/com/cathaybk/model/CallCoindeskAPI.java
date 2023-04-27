package tw.com.cathaybk.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.com.cathaybk.role.Coin;
import tw.com.cathaybk.util.HttpclientUtil;
import tw.com.cathaybk.util.MyDateUtil;

public class CallCoindeskAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final static String URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

	public Map<String, Object> run() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			logger.debug("preparing to send request...");
			JSONObject data = HttpclientUtil.httpGet(URL);
			if(data == null) {
				map.put("message","未成功獲取該網址的返回值。");
				return map;
			}
			logger.debug("Preparing to parse the return value...");
			return parserJson(data);
		} catch (Exception e) {
			logger.error("{}", e);
		}
		//回傳空資料
		map.put("message","發生錯誤，無法取得參數。");
		return map;
	}

	public Map<String, Object> parserJson(String json) throws JSONException, ParseException {
		return parserJson(new JSONObject(json));
	}

	public Map<String, Object> parserJson(JSONObject json) throws JSONException, ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.debug("preparing to parse time...");
		// 取時間值
		String updated = json.getJSONObject("time").get("updated").toString();
		// 讀入的時間格式
		String inputDateFormat = "MMM d, yyyy HH:mm:ss z";
		// 讀出的時間格式
		String outputDateFormat = "yyyy/MM/dd HH:mm:ss";
		// 轉換
		String date = MyDateUtil.dateFormatConverter(updated, inputDateFormat, outputDateFormat, Locale.ENGLISH);
		map.put("date", date);
		logger.debug("preparing to coin data...");
		JSONObject bpi = json.getJSONObject("bpi");
		Iterator<String> b = bpi.keys();
		List<Coin> list = new ArrayList<Coin>();
		while (b.hasNext()) {
			JSONObject jobj = bpi.getJSONObject(b.next());
			//將json參數放入Coin物件
			Coin coin = new Coin();
			coin.setCode(jobj.getString(Coin.CONSTANT_CODE));
			coin.setRate(jobj.getString(Coin.CONSTANT_RATE));
			coin.setRate_float(jobj.getDouble(Coin.CONSTANT_RATE_FLOAT));
			coin.setDescription(jobj.getString(Coin.CONSTANT_DESCRIPTION));
			list.add(coin);
		}
		map.put("coinList", list);
		return map;
	}
}
