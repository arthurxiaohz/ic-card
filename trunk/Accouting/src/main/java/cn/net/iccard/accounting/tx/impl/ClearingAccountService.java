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
import cn.net.iccard.bm.accounting.model.VoucherType;
import cn.net.iccard.bm.accounting.service.ActAccountManager;
import cn.net.iccard.bm.settleservice.model.TblStlCleaningDetail;
import cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;

public class ClearingAccountService implements IClearingAccountService {

	private IAccountTxService accountTxService;

	private ActAccountManager actAccountManager = (ActAccountManager) SpringContextHolder
			.getBean(ActAccount.class);

	private TblStlCleaningDetailManager tblStlCleaningDetailManager = (TblStlCleaningDetailManager) SpringContextHolder
			.getBean(TblStlCleaningDetail.class);

	private TblTxPayMentOrderManager tblTxPayMentOrderManager = (TblTxPayMentOrderManager) SpringContextHolder
			.getBean(TblTxPayMentOrder.class);

	public ICommonAccountResponse doPaymentAccountClearing(
			IPaymentClearingAccountRequest paymentClearingAccountRequest) {

		// begin������֮ǰ��Ԥ֧��״̬��ͬʱ�����˻�����
		TblStlCleaningDetail tblStlCleaningDetail = (TblStlCleaningDetail) tblStlCleaningDetailManager
				.getObjectById(paymentClearingAccountRequest.getBizLogId());
		int originalBizLogId = ((TblTxPayMentOrder) tblTxPayMentOrderManager
				.getObjects(
						FilterFactory.getSimpleFilter("plTxTraceNo",
								tblStlCleaningDetail.getPlTxTraceNo())).get(0))
				.getId();

		accountTxService.doSettle(VoucherType.VOUCHERTYPE_TRANSFER,
				BizType.BIZTYPE_PREPAID, originalBizLogId,
				BizType.BIZTYPE_CONFIRMPAY, paymentClearingAccountRequest
						.getBizLogId());
		// begin������֮ǰ��Ԥ֧��״̬��ͬʱ�����˻�����

		// begin���̻�������
		AccountDebitCreditRequest accountDebitCreditRequest = new AccountDebitCreditRequest();
		// �̻��������˻�
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
				.getMchtFee());
		accountDebitCreditRequest.setBizType(BizType.BIZTYPE_CONFIRMPAY);
		accountDebitCreditRequest.setBizLogId(paymentClearingAccountRequest
				.getBizLogId());
		accountTxService.debit(accountDebitCreditRequest);
		// end���̻�������

		// begin���̻�������
		// �̻������˻�
		int mchtVirtualAccountId = ((ActAccount) actAccountManager.getObjects(
				FilterFactory.getSimpleFilter("accountPartyType",
						AccountPartyType.ACCOUNTPARTYTYPE_MCHT).addCondition(
						"accountParty",
						paymentClearingAccountRequest.getUserName())
						.addCondition("accountCatalog",
								AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT))
				.get(0)).getId();

		accountDebitCreditRequest.setAccountId(mchtVirtualAccountId);
		accountDebitCreditRequest.setAmount(paymentClearingAccountRequest
				.getMchtOrderAmount()
				- paymentClearingAccountRequest.getMchtFee());
		accountTxService.debit(accountDebitCreditRequest);
		// begin���̻�������

		return new SimpleCommonAccountResponse(EAccountResponse.S0000);
	}

	public ICommonAccountResponse doRefundAccountClearing(
			IRefundClearingAccountRequest refundClearingAccountRequest) {

		AccountDebitCreditRequest accountDebitCreditRequest = new AccountDebitCreditRequest();
		accountDebitCreditRequest.setBizType(BizType.BIZTYPE_CONFIRMREFUND);
		accountDebitCreditRequest.setBizLogId(refundClearingAccountRequest
				.getBizLogId());
		// �̻�Ӧ�˽��
		int mchtReturnAmount = refundClearingAccountRequest.getAmount();

		TblStlCleaningDetail tblStlCleaningDetail = (TblStlCleaningDetail) tblStlCleaningDetailManager
				.getObjectById(refundClearingAccountRequest.getBizLogId());

		if (refundClearingAccountRequest.isFeeReturn()) {
			// begin���˻��̻�������

			// �̻��������˻�
			int mchtFeeAccountId = ((ActAccount) actAccountManager.getObjects(
					FilterFactory.getSimpleFilter("accountPartyType",
							AccountPartyType.ACCOUNTPARTYTYPE_MCHT)
							.addCondition("accountParty",
									refundClearingAccountRequest.getMchtNo())
							.addCondition("accountCatalog",
									AccountCatalog.ACCOUNTCATALOG_FEEACCOUNT))
					.get(0)).getId();

			accountDebitCreditRequest.setAccountId(mchtFeeAccountId);
			accountDebitCreditRequest.setAmount(refundClearingAccountRequest
					.getMchtFee());

			accountTxService.credit(accountDebitCreditRequest);
			// end���˻��̻�������
			mchtReturnAmount = mchtReturnAmount
					- refundClearingAccountRequest.getMchtFee();
		}

		// �̻�������

		// begin���ʽ�ӻ�Ա�����˻��˻ػ�Ա�����˻���ԭ����ƾ֤��Ϊ�Ѵ���
		AccountPayableCancelTransferRequest accountPayableCancelTransferRequest = new AccountPayableCancelTransferRequest();
		// ��Ա�����˻�
		int accountIdFrom = ((ActAccount) actAccountManager
				.getObjects(
						FilterFactory
								.getSimpleFilter(
										"accountPartyType",
										AccountPartyType.ACCOUNTPARTYTYPE_MEMBER)
								.addCondition(
										"accountParty",
										refundClearingAccountRequest
												.getUserName())
								.addCondition(
										"accountCatalog",
										AccountCatalog.ACCOUNTCATALOG_GUARANTEEACCOUNT))
				.get(0)).getId();
		accountPayableCancelTransferRequest.setAccountIdFrom(accountIdFrom);
		// ��Ա�����˻�
		int accountIdTo = ((ActAccount) actAccountManager.getObjects(
				FilterFactory.getSimpleFilter("accountPartyType",
						AccountPartyType.ACCOUNTPARTYTYPE_MEMBER).addCondition(
						"accountParty",
						refundClearingAccountRequest.getUserName())
						.addCondition("accountCatalog",
								AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT))
				.get(0)).getId();
		accountPayableCancelTransferRequest.setAccountIdTo(accountIdTo);
		accountPayableCancelTransferRequest
				.setAmount(refundClearingAccountRequest.getAmount());
		accountPayableCancelTransferRequest
				.setBizType(BizType.BIZTYPE_CONFIRMREFUND);
		accountPayableCancelTransferRequest
				.setBizLogId(refundClearingAccountRequest.getBizLogId());
		int relatedBizLogId = ((TblTxPayMentOrder) tblTxPayMentOrderManager
				.getObjects(
						FilterFactory.getSimpleFilter("plTxTraceNo",
								tblStlCleaningDetail.getRefundOrderId()))
				.get(0)).getId();
		accountPayableCancelTransferRequest.setRelatedBizLogId(relatedBizLogId);

		accountTxService.transfer(accountPayableCancelTransferRequest);
		// end���ʽ�ӻ�Ա�����˻��˻ػ�Ա�����˻�

		// �̻������˻�
		int mchtVirtualAccountId = ((ActAccount) actAccountManager.getObjects(
				FilterFactory.getSimpleFilter("accountPartyType",
						AccountPartyType.ACCOUNTPARTYTYPE_MEMBER).addCondition(
						"accountParty",
						refundClearingAccountRequest.getUserName())
						.addCondition("accountCatalog",
								AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT))
				.get(0)).getId();

		accountDebitCreditRequest.setAccountId(mchtVirtualAccountId);
		accountDebitCreditRequest.setAmount(mchtReturnAmount);
		accountTxService.credit(accountDebitCreditRequest);

		return new SimpleCommonAccountResponse(EAccountResponse.S0000);
	}

}
