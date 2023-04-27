package tw.com.cathaybk.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tw.com.cathaybk.dao.CoinDao;
import tw.com.cathaybk.entity.Coin;

@Service
public class CoinService {
	@Autowired
	CoinDao coinDao;

	public List<Map<String,Object>> getCoins() {
		return coinDao.findAllJoinLang();
	}

	public List<Map<String, Object>> getCoinById(Integer id) {
		return coinDao.findAllByIdJoinLang(id);
	}

	public Integer addCoin(Coin coin) {
		Coin rltcoin = coinDao.save(coin);
		return rltcoin.getCoin_id();
	}

	public ResponseEntity<String> updateCoin(Integer id, Coin coin) {
		Optional<Coin> isExistCoin = coinDao.findById(id);
		if (isExistCoin.isPresent() == false) {
			return badResponse("此筆資料未存在");
		}
		if (coin.getCoin_code() == null) {
			return badResponse("未輸入Coin_code");
		}
		if (coin.getCoin_rate() == null) {
			return badResponse("未輸入Coin_rate");
		}
		Coin updateCoin = isExistCoin.get();
		updateCoin.setCoin_code(coin.getCoin_code());
		updateCoin.setCoin_rate(coin.getCoin_rate());
		coinDao.save(updateCoin);
		return okResponse();
	}

	public ResponseEntity<String> deleteCoin(Integer id) {
		Optional<Coin> findTodo = coinDao.findById(id);
		if (findTodo.isPresent() == false) {
			return badResponse("欲刪除的資料不存在");
		}
		coinDao.deleteById(id);
		return okResponse();
	}

	private ResponseEntity<String> badResponse(String message) {
		return makeResponse(HttpStatus.BAD_REQUEST, message);
	}

	private ResponseEntity<String> okResponse() {
		return makeResponse(HttpStatus.OK, "");
	}

	private ResponseEntity<String> makeResponse(HttpStatus status, String message) {
		return ResponseEntity.status(status).body(message);
	}
}
