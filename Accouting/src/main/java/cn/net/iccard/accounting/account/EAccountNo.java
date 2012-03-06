package cn.net.iccard.accounting.account;

public enum EAccountNo {

	/**
	 * ƽ̨
	 */
	PLATFORM(1, "20120101000000000001");

	int accountId;

	String accountNo;

	EAccountNo(int accountId, String acountNo) {
		this.accountNo = accountNo;
	}
}
