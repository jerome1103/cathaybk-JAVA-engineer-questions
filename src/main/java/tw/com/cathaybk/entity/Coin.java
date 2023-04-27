package tw.com.cathaybk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coin")
public class Coin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer coin_id;

	@Column(nullable = false)
	private String coin_code;

	@Column(nullable = false)
	private Float coin_rate;

	public Integer getCoin_id() {
		return coin_id;
	}

	public void setCoin_id(Integer coin_id) {
		this.coin_id = coin_id;
	}

	public String getCoin_code() {
		return coin_code;
	}

	public void setCoin_code(String coin_code) {
		this.coin_code = coin_code;
	}

	public Float getCoin_rate() {
		return coin_rate;
	}

	public void setCoin_rate(Float coin_rate) {
		this.coin_rate = coin_rate;
	}

	@Override
	public String toString() {
		return "Coin [coin_id=" + coin_id + ", coin_code=" + coin_code + ", coin_rate=" + coin_rate + "]";
	}

}
