package tw.com.cathaybk.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.cathaybk.entity.Coin;
import tw.com.cathaybk.model.CallCoindeskAPI;
import tw.com.cathaybk.service.CoinService;

@RestController
public class CoinController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CoinService coinService;

	@GetMapping("/coin")
	public List<Map<String, Object>> queryCoin() {
		return coinService.getCoins();
	}

	@GetMapping("/coin/{id}")
	public List<Map<String, Object>> queryCoin(@PathVariable Integer id) {
		return coinService.getCoinById(id);
	}

	@PostMapping("/coin")
	public ResponseEntity<Integer> addCoin(@RequestBody Coin coin) {
		Integer rtl = coinService.addCoin(coin);
		return ResponseEntity.status(HttpStatus.CREATED).body(rtl);
	}

	@PutMapping("/coin/{id}")
	public ResponseEntity<String> updateCoin(@PathVariable Integer id, @RequestBody Coin coin) {
		return coinService.updateCoin(id, coin);
	}

	@DeleteMapping("/coin/{id}")
	public ResponseEntity<String> deleteCoin(@PathVariable Integer id) {
		return coinService.deleteCoin(id);
	}

	@ResponseBody
	@GetMapping("/coin/desk")
	public Map<String, Object> queryCoinDesk() {
		CallCoindeskAPI callApi = new CallCoindeskAPI();
		return callApi.run();
	}
}
