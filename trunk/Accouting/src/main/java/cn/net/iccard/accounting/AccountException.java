package cn.net.iccard.accounting;

public class AccountException extends RuntimeException {

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
