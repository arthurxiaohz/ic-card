package cn.net.iccard.accounting;

/**
 * �˻�������Ӧ
 * 
 * @author Angi.Wang
 */
public enum EAccountResponse {

	S0000("����ɹ�"),

	E0001("����");

	private String value;

	EAccountResponse(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
