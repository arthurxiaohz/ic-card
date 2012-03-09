package cn.net.iccard.accounting;

/**
 * 账务处理响应
 * 
 * @author Angi.Wang
 */
public enum EAccountResponse {

	S0000("处理成功"),

	E0001("余额不足"),

	E0002("没有需要结算的商户结算申请");

	private String value;

	EAccountResponse(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
