package tw.com.cathaybk;

import java.text.ParseException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.cathaybk.entity.Coin;
import tw.com.cathaybk.model.CallCoindeskAPI;
import tw.com.cathaybk.service.CoinService;
import tw.com.cathaybk.util.HttpclientUtil;

@SpringBootTest
class CathaybkJavaEngineerQuestionsApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	void contextLoads() {
		// 1.測試呼叫查詢幣別對應表資料API，並顯示其內容
//		testQueryCoinAPI();
		// 2.測試呼叫新增幣別對應表資料API
//		testUpdeateCoinAPI();
		// 3.測試呼叫修改幣別對應表資料API，並顯示其內容
//		testUpdeateCoinAPI();
		// 4.測試呼叫刪除幣別對應表資料API
//		testDeleteCoinAPI();
		// 5.測試呼叫coindesk API，並顯示其內容
//		testCallCoindeskAPI();
		// 6.測試呼叫資料轉換的API，並顯示其內容
//		testCallParserDataAPI();
	}
	
	@Autowired
	CoinService CoinService;
	
	// 1.測試呼叫查詢幣別對應表資料API，並顯示其內容
	@Test
	void testQueryCoinAPI() {
		logger.error("{}",CoinService.getCoins());
	}
	
	// 2.測試呼叫新增幣別對應表資料API
	@Test
	void testAddCoinAPI() {
		Coin coin = new Coin();
		coin.setCoin_code("CNY");
		coin.setCoin_rate(new Float(4.328));
		logger.error("{}",CoinService.addCoin(coin));
	}
	
	// 3.測試呼叫修改幣別對應表資料API，並顯示其內容
	@Test
	void testUpdeateCoinAPI() {
		Integer id = 11;
		Coin coin = new Coin();
		coin.setCoin_code("KRW");
		coin.setCoin_rate(new Float(0.02122));
		logger.error("{}",CoinService.updateCoin(id, coin));
	}
	
	// 4.測試呼叫刪除幣別對應表資料API
	@Test
	void testDeleteCoinAPI() {
		logger.error("{}",CoinService.deleteCoin(11));
	}
	
	// 5.測試呼叫coindesk API，並顯示其內容
	private final String URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
	@Test
	void testCallCoindeskAPI() {
		try {
			logger.error("{}", HttpclientUtil.httpGet(URL));
		} catch (Exception e) {
			logger.error("{}", e);
		}
	}

	// 6.測試呼叫資料轉換的API，並顯示其內容
	private final String data = "{\"time\":{\"updated\":\"Apr 26, 2023 04:48:00 UTC\",\"updatedISO\":\"2023-04-26T04:48:00+00:00\",\"updateduk\":\"Apr 26, 2023 at 05:48 BST\"},\"disclaimer\":\"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\"chartName\":\"Bitcoin\",\"bpi\":{\"USD\":{\"code\":\"USD\",\"symbol\":\"&#36;\",\"rate\":\"28,309.8335\",\"description\":\"United States Dollar\",\"rate_float\":28309.8335},\"GBP\":{\"code\":\"GBP\",\"symbol\":\"&pound;\",\"rate\":\"23,655.4704\",\"description\":\"British Pound Sterling\",\"rate_float\":23655.4704},\"EUR\":{\"code\":\"EUR\",\"symbol\":\"&euro;\",\"rate\":\"27,577.9111\",\"description\":\"Euro\",\"rate_float\":27577.9111}}}";
	@Test
	void testCallParserDataAPI() {
		CallCoindeskAPI api = new CallCoindeskAPI();
		try {
			logger.error("{}", api.parserJson(data));
		} catch (JSONException | ParseException e) {
			logger.error("{}", e);
		}
	}
}