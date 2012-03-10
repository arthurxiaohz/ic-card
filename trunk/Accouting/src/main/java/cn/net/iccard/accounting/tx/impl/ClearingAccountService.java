package cn.net.iccard.accounting.tx.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.ICommonAccountResponse;
import cn.net.iccard.accounting.impl.SimpleCommonAccountResponse;
import cn.net.iccard.accounting.tx.IAccountDebitCreditResponse;
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
import cn.net.iccard.bm.settleservice.model.SettleApplyStatus;
import cn.net.iccard.bm.settleservice.model.SettleBatchStatus;
import cn.net.iccard.bm.settleservice.model.TblStlCleaningDetail;
import cn.net.iccard.bm.settleservice.model.TblStlSettleApply;
import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager;
import cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager;
import cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager;
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

	private TblStlSettleApplyManager tblStlSettleApplyMgr = (TblStlSettleApplyManager) SpringContextHolder
			.getBean(TblStlSettleApply.class);

	private TblStlSettleBatchManager tblStlSettleBatchMgr = (TblStlSettleBatchManager) SpringContextHolder
			.getBean(TblStlSettleBatch.class);

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
		// end������֮ǰ��Ԥ֧��״̬��ͬʱ�����˻�����

		// begin���̻�������
		AccountDebitCreditRequest accountDebitCreditRequest = new AccountDebitCreditRequest();
		// �̻��������˻�
		int mchtFeeAccountId = ((ActAccount) actAccountManager.getObjects(
				FilterFactory.getSimpleFilter("accountPartyType",
						AccountPartyType.ACCOUNTPARTYTYPE_MCHT).addCondition(
						"accountParty",
						paymentClearingAccountRequest.getMchtNo())
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
						paymentClearingAccountRequest.getMchtNo())
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
		int mchtReturnAmount = refundClearingAccountRequest
				.getMchtOrderAmount();

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
						AccountPartyType.ACCOUNTPARTYTYPE_MCHT).addCondition(
						"accountParty",
						refundClearingAccountRequest.getMchtNo()).addCondition(
						"accountCatalog",
						AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT)).get(0))
				.getId();

		accountDebitCreditRequest.setAccountId(mchtVirtualAccountId);
		accountDebitCreditRequest.setAmount(mchtReturnAmount);
		accountTxService.credit(accountDebitCreditRequest);

		return new SimpleCommonAccountResponse(EAccountResponse.S0000);
	}

	public ICommonAccountResponse doSettle() {
		// �������κ�
		Date settleDate = new Date();
		String settleBatchNo = DateUtils.format(settleDate, "yyyyMMddHHmmss")
				+ getNextSeq();
		// TODO �����˹���
		List tblStlSettleApplys = tblStlSettleApplyMgr.getObjects(FilterFactory
				.getSimpleFilter("settleApplyStatus",
						SettleApplyStatus.SETTLEAPPLYSTATUS_CHECKING));
		if (null == tblStlSettleApplys || tblStlSettleApplys.size() == 0) {
			return new SimpleCommonAccountResponse(EAccountResponse.E0002);
		}
		TblStlSettleBatch tblStlSettleBatch = new TblStlSettleBatch();
		tblStlSettleBatch.setSettleBatchNo(settleBatchNo);
		int totalAmount = 0;
		tblStlSettleBatch.setTotalAmount(totalAmount);
		int totalCount = 0;
		tblStlSettleBatch.setTotalCount(totalCount);
		// ��������δ��
		tblStlSettleBatch
				.setSettleBatchStatus(SettleBatchStatus.SETTLEBATCHSTATUS_SETTLED);
		tblStlSettleBatch.setSettleDate(settleDate);
		
		tblStlSettleBatchMgr.saveTblStlSettleBatch(tblStlSettleBatch);

		for (int i = 0; i < tblStlSettleApplys.size(); i++) {
			TblStlSettleApply tblStlSettleApply = (TblStlSettleApply) tblStlSettleApplys
					.get(i);
			AccountDebitCreditRequest accountDebitCreditRequest = new AccountDebitCreditRequest();
			// �̻������˻�
			int mchtVirtualAccountId = ((ActAccount) actAccountManager
					.getObjects(
							FilterFactory
									.getSimpleFilter(
											"accountPartyType",
											AccountPartyType.ACCOUNTPARTYTYPE_MCHT)
									.addCondition(
											"accountParty",
											tblStlSettleApply.getTblMchtInfo()
													.getMchtNo())
									.addCondition(
											"accountCatalog",
											AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT))
					.get(0)).getId();

			accountDebitCreditRequest.setAccountId(mchtVirtualAccountId);
			accountDebitCreditRequest.setAmount(tblStlSettleApply.getAmount());
			accountDebitCreditRequest.setBizType(BizType.BIZTYPE_SETTLEMENT);
			accountDebitCreditRequest.setBizLogId(tblStlSettleApply.getId());
			accountDebitCreditRequest.setRemark("����");

			IAccountDebitCreditResponse accountDebitCreditResponse = accountTxService
					.credit(accountDebitCreditRequest);
			if (EAccountResponse.S0000.name().equals(
					accountDebitCreditResponse.getRespCode())) {
				// ���ǳɹ�
				// ��������δ��
				tblStlSettleApply
						.setSettleApplyStatus(SettleApplyStatus.SETTLEAPPLYSTATUS_SETTLED);
				totalAmount = +tblStlSettleApply.getAmount();
				totalCount++;
			} else {
				// ����ʧ��
				tblStlSettleApply
						.setSettleApplyStatus(SettleApplyStatus.SETTLEAPPLYSTATUS_SETTLEFAIL);
				tblStlSettleApply.setRemark(accountDebitCreditResponse
						.getRespMsg());
			}
			tblStlSettleApply.setTblStlSettleBatch(tblStlSettleBatch);
			tblStlSettleApply.setLastUpdatedDatetime(new Timestamp(System
					.currentTimeMillis()));
			tblStlSettleApply
					.setLastUpdatedBy(org.hi.framework.security.context.UserContextHelper
							.getUser());

			tblStlSettleApplyMgr.saveTblStlSettleApply(tblStlSettleApply);
		}
		tblStlSettleBatchMgr.saveTblStlSettleBatch(tblStlSettleBatch);
		return new SimpleCommonAccountResponse(EAccountResponse.S0000);
	}

	private int seq = 0;
	private final int MAX_PER_SECOND = 99;

	private synchronized int getNextSeq() {
		seq++;
		seq %= MAX_PER_SECOND;
		return seq + 100;
	}

	public IAccountTxService getAccountTxService() {
		return accountTxService;
	}

	public void setAccountTxService(IAccountTxService accountTxService) {
		this.accountTxService = accountTxService;
	}

}
