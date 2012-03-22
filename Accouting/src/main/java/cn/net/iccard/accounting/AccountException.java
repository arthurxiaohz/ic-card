package cn.net.iccard.accounting;

import org.hi.framework.web.BusinessException;

/**
 * 账务处理异常
 * 
 * <p>
 * 继承BusinessException，因为框架对于BusinessException异常有专门处理，页面显示异常msg，而不是堆栈信息
 * 
 * @author Angi
 * 
 */
public class AccountException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8481199063525360589L;

	private EAccountResponse eAccountResponse;

	public AccountException(EAccountResponse eAccountResponse) {
		super(eAccountResponse.getValue());
		this.eAccountResponse = eAccountResponse;
	}

	public AccountException(EAccountResponse eAccountResponse, String message) {
		super(message);
		this.eAccountResponse = eAccountResponse;
	}

	public EAccountResponse getEAccountResponse() {
		return eAccountResponse;
	}

	public void setEAccountResponse(EAccountResponse accountResponse) {
		eAccountResponse = accountResponse;
	}

}
