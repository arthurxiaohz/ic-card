package cn.net.iccard.accounting.tx.impl;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.ICommonAccountResponse;
import cn.net.iccard.accounting.impl.SimpleCommonAccountResponse;
import cn.net.iccard.accounting.tx.IAccountTxService;
import cn.net.iccard.accounting.tx.IClearingAccountService;
import cn.net.iccard.accounting.tx.IPaymentClearingAccountRequest;
import cn.net.iccard.accounting.tx.IRefundClearingAccountRequest;
import cn.net.iccard.bm.accounting.model.AccountCatalog;
import cn.net.iccard.bm.accounting.model.AccountPartyType;
import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.model.BizType;
import cn.net.iccard.bm.accounting.service.ActAccountManager;

public class ClearingAccountService implements IClearingAccountService {

	private IAccountTxService accountTxService;

	private ActAccountManager actAccountManager = (ActAccountManager) SpringContextHolder
			.getBean(ActAccount.class);

	public ICommonAccountResponse doPaymentAccountClearing(
			IPaymentClearingAccountRequest paymentClearingAccountRequest) {

		// 手续费
		AccountDebitCreditRequest accountDebitCreditRequest = new AccountDebitCreditRequest();

		int mchtFeeAccountId = ((ActAccount) actAccountManager.getObjects(
				FilterFactory.getSimpleFilter("accountPartyType",
						AccountPartyType.ACCOUNTPARTYTYPE_MCHT).addCondition(
						"accountParty",
						paymentClearingAccountRequest.getUserName())
						.addCondition("accountCatalog",
								AccountCatalog.ACCOUNTCATALOG_FEEACCOUNT)).get(
				0)).getId();

		accountDebitCreditRequest.setAccountId(mchtFeeAccountId);
		accountDebitCreditRequest.setAmount(paymentClearingAccountRequest
				.getAmount());
		accountDebitCreditRequest.setBizType(BizType.BIZTYPE_CLEARING);
		accountDebitCreditRequest.setBizLogId(paymentClearingAccountRequest
				.getBizLogId());
		accountTxService.debit(accountDebitCreditRequest);

		// 商户结算金额
		int mchtVirtualAccountId = ((ActAccount) actAccountManager.getObjects(
				FilterFactory.getSimpleFilter("accountPartyType",
						AccountPartyType.ACCOUNTPARTYTYPE_MCHT).addCondition(
						"accountParty",
						paymentClearingAccountRequest.getUserName())
						.addCondition("accountCatalog",
								AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT))
				.get(0)).getId();

		return new SimpleCommonAccountResponse(EAccountResponse.S0000);
	}

	public ICommonAccountResponse doRefundAccountClearing(
			IRefundClearingAccountRequest refundClearingAccountRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
