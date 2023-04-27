package tw.com.cathaybk.role;

public class Coin {
	public static final String CONSTANT_CODE = "code";
	public static final String CONSTANT_RATE = "rate";
	public static final String CONSTANT_RATE_FLOAT = "rate_float";
	public static final String CONSTANT_DESCRIPTION = "description";

	String code;
	String rate;
	Double rate_float;
	String description;
	String coinType;

	public Coin() {
	}

	public Coin(String code, String rate, Double rate_float, String description) {
		this.code = code;
		this.rate = rate;
		this.rate_float = rate_float;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		switch (code) {
		case "USD":
			this.coinType = "美元";
			break;
		case "GBP":
			this.coinType = "英鎊";
			break;
		case "EUR":
			this.coinType = "歐元";
			break;
		default:
			this.coinType = "未知";
			break;
		}
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Double getRate_float() {
		return rate_float;
	}

	public void setRate_float(Double rate_float) {
		this.rate_float = rate_float;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoinType() {
		return coinType;
	}

	public void setCoinType(String coinType) {
		this.coinType = coinType;
	}

	@Override
	public String toString() {
		return "Coin [code=" + code + ", rate=" + rate + ", rate_float=" + rate_float + ", description=" + description
				+ ", coinType=" + coinType + "]";
	}

}
