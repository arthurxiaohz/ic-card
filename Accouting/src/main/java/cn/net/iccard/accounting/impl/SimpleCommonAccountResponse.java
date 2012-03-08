package cn.net.iccard.accounting.impl;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.ICommonAccountResponse;

public class SimpleCommonAccountResponse implements ICommonAccountResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6891766487333165514L;

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

}
