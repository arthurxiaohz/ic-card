package cn.net.iccard.accounting;

/**
 * 账户处理响应
 * 
 * @author Angi.Wang
 */
public enum EAccountResponse {

	S0000("处理成功"),

	E0001("余额不足");

	private String value;

	EAccountResponse(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
