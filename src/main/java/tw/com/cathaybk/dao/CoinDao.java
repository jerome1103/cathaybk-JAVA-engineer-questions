package tw.com.cathaybk.dao;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tw.com.cathaybk.entity.Coin;


public interface CoinDao extends CrudRepository<Coin, Integer> {
	
	@Query(
			value = "SELECT c.coin_id,c.coin_code,c.coin_rate,IFNULL(l.code_name, '未知') code_name "
					+ "FROM coin AS c "
					+ "LEFT JOIN lang AS l "
					+ "ON c.coin_code = l.coin_code",
			nativeQuery = true
	)
	
	List<Map<String,Object>> findAllJoinLang();
	
	@Query(
			value = "SELECT c.coin_id,c.coin_code,c.coin_rate,IFNULL(l.code_name, '未知') code_name "
					+ "FROM coin AS c"
					+ " LEFT JOIN lang AS l"
					+ " ON c.coin_code = l.coin_code"
					+ " WHERE c.coin_id = :id",
			nativeQuery = true
	)
	List<Map<String,Object>> findAllByIdJoinLang(Integer id);
}