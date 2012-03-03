package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.EAccountResponse;
import cn.net.iccard.accounting.tx.ICommonAccountResponse;

public class SimpleCommonAccountResponse implements ICommonAccountResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6017528031238937260L;

	/**
	 * œÏ”¶¬Î
	 * 
	 * @return
	 */
	private String respCode;

	/**
	 * œÏ”¶√Ë ˆ
	 * 
	 * @return
	 */
	private String respMsg;

	/**
	 * ∆æ÷§∫≈
	 * 
	 * @return
	 */
	private String voucherNo;

	public SimpleCommonAccountResponse() {
		super();
	}

	public SimpleCommonAccountResponse(EAccountResponse eAccountResponse) {
		super();
		this.respCode = eAccountResponse.name();
		this.respMsg = eAccountResponse.getValue();

	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

}
