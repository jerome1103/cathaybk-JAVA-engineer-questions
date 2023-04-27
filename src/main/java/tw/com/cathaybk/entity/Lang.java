package tw.com.cathaybk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lang")
public class Lang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer lang_id;

	@Column(nullable = false)
	String coin_id;

	@Column(nullable = false)
	String coin_code;

	@Column(nullable = false)
	String code_name;

	public String getCoin_code() {
		return coin_code;
	}

	public void setCoin_code(String coin_code) {
		this.coin_code = coin_code;
	}

	public String getCode_name() {
		return code_name;
	}

	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}

	public Integer getLang_id() {
		return lang_id;
	}

	public void setLang_id(Integer lang_id) {
		this.lang_id = lang_id;
	}

	public String getCoin_id() {
		return coin_id;
	}

	public void setCoin_id(String coin_id) {
		this.coin_id = coin_id;
	}

	@Override
	public String toString() {
		return "Lang [lang_id=" + lang_id + ", coin_id=" + coin_id + ", coin_code=" + coin_code + ", code_name="
				+ code_name + "]";
	}

}
