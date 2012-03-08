package cn.net.iccard.accounting.tx.impl;

import java.util.Date;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.accounting.AccountException;
import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.tx.IAccountDebitCreditRequest;
import cn.net.iccard.accounting.tx.IAccountDebitCreditResponse;
import cn.net.iccard.accounting.tx.IAccountPaidTransferRequest;
import cn.net.iccard.accounting.tx.IAccountPayableTransferRequest;
import cn.net.iccard.accounting.tx.IAccountTransferRequest;
import cn.net.iccard.accounting.tx.IAccountTransferResponse;
import cn.net.iccard.accounting.tx.IAccountTxService;
import cn.net.iccard.bm.accounting.model.DebitOrCredit;
import cn.net.iccard.bm.accounting.model.SettleStatus;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.model.TblActAccountDetail;
import cn.net.iccard.bm.accounting.model.TblActDebitCreditVoucher;
import cn.net.iccard.bm.accounting.model.TblActTransferVoucher;
import cn.net.iccard.bm.accounting.model.VoucherType;
import cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager;
import cn.net.iccard.bm.accounting.service.TblActAccountDetailManager;
import cn.net.iccard.bm.accounting.service.TblActDebitCreditVoucherManager;
import cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager;

public class AccountTxService implements IAccountTxService {

	private TblActDebitCreditVoucherManager tblActDebitCreditVoucherMgr = (TblActDebitCreditVoucherManager) SpringContextHolder
			.getBean(TblActDebitCreditVoucher.class);
	private TblActTransferVoucherManager tblActTransferVoucherMgr = (TblActTransferVoucherManager) SpringContextHolder
			.getBean(TblActTransferVoucher.class);
	private TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager) SpringContextHolder
			.getBean(TblActAccountBalance.class);
	private TblActAccountDetailManager tblActAccountDetailMgr = (TblActAccountDetailManager) SpringContextHolder
			.getBean(TblActAccountDetail.class);

	public IAccountDebitCreditResponse debit(
			IAccountDebitCreditRequest accountDebitCreditRequest) {
		return debitOrCredit(accountDebitCreditRequest,
				DebitOrCredit.DEBITORCREDIT_DEBIT);
	}

	public IAccountDebitCreditResponse credit(
			IAccountDebitCreditRequest accountDebitCreditRequest) {
		return debitOrCredit(accountDebitCreditRequest,
				DebitOrCredit.DEBITORCREDIT_CREDIT);
	}

	/**
	 * �����
	 * 
	 * @param accountDebitCreditRequest
	 * @param debitOrCredit
	 * @return
	 */
	private IAccountDebitCreditResponse debitOrCredit(
			IAccountDebitCreditRequest accountDebitCreditRequest,
			int debitOrCredit) throws AccountException {

		// �����ƾ֤
		TblActDebitCreditVoucher tblActDebitCreditVoucher = new TblActDebitCreditVoucher();

		tblActDebitCreditVoucher.setVoucherNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());

		tblActDebitCreditVoucher.setActAccount(tblActAccountBalanceMgr
				.getActAccountById(accountDebitCreditRequest.getAccountId()));

		tblActDebitCreditVoucher.setAmount(accountDebitCreditRequest
				.getAmount());
		tblActDebitCreditVoucher.setDebitOrCredit(debitOrCredit);
		tblActDebitCreditVoucher.setBizType(accountDebitCreditRequest
				.getBizType());
		tblActDebitCreditVoucher.setBizLogId(accountDebitCreditRequest
				.getBizLogId());
		tblActDebitCreditVoucher.setRemark(accountDebitCreditRequest
				.getRemark());

		tblActDebitCreditVoucherMgr
				.saveTblActDebitCreditVoucher(tblActDebitCreditVoucher);

		charge(accountDebitCreditRequest.getAccountId(),
				accountDebitCreditRequest.getAmount(), debitOrCredit,
				VoucherType.VOUCHERTYPE_DEBITORCREDIT, tblActDebitCreditVoucher
						.getVoucherNo(), accountDebitCreditRequest.getRemark(),
				null);

		return new AccountDebitCreditResponse(EAccountResponse.S0000,
				tblActDebitCreditVoucher.getVoucherNo());

	}

	public IAccountTransferResponse transfer(
			IAccountTransferRequest accountTransferRequest) {

		// ת��ƾ֤
		TblActTransferVoucher tblActTransferVoucher = new TblActTransferVoucher();

		tblActTransferVoucher.setVoucherNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());
		tblActTransferVoucher.setActAccountFrom(tblActAccountBalanceMgr
				.getActAccountById(accountTransferRequest.getAccountIdFrom()));
		tblActTransferVoucher.setActAccountTo(tblActAccountBalanceMgr
				.getActAccountById(accountTransferRequest.getAccountIdTo()));

		tblActTransferVoucher.setAmount(accountTransferRequest.getAmount());
		tblActTransferVoucher.setBizType(accountTransferRequest.getBizType());
		tblActTransferVoucher.setBizLogId(accountTransferRequest.getBizLogId());
		tblActTransferVoucher.setRemark(accountTransferRequest.getRemark());

		tblActTransferVoucherMgr
				.saveTblActTransferVoucher(tblActTransferVoucher);

		// ����
		credit(accountTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo(), null);

		// ���
		debit(accountTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo(), null);

		return null;

	}

	public IAccountTransferResponse transfer(
			IAccountPayableTransferRequest accountRcvOrPabTransferRequest) {

		// ת��ƾ֤
		TblActTransferVoucher tblActTransferVoucher = new TblActTransferVoucher();

		tblActTransferVoucher.setVoucherNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());
		tblActTransferVoucher.setActAccountFrom(tblActAccountBalanceMgr
				.getActAccountById(accountRcvOrPabTransferRequest
						.getAccountIdFrom()));
		tblActTransferVoucher.setActAccountTo(tblActAccountBalanceMgr
				.getActAccountById(accountRcvOrPabTransferRequest
						.getAccountIdTo()));

		tblActTransferVoucher.setAmount(accountRcvOrPabTransferRequest
				.getAmount());
		tblActTransferVoucher.setBizType(accountRcvOrPabTransferRequest
				.getBizType());
		tblActTransferVoucher.setBizLogId(accountRcvOrPabTransferRequest
				.getBizLogId());
		tblActTransferVoucher.setRemark(accountRcvOrPabTransferRequest
				.getRemark());

		tblActTransferVoucherMgr
				.saveTblActTransferVoucher(tblActTransferVoucher);

		// ����
		credit(accountRcvOrPabTransferRequest,
				VoucherType.VOUCHERTYPE_TRANSFER, tblActTransferVoucher
						.getVoucherNo(), null);

		// ���
		debit(accountRcvOrPabTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo(),
				accountRcvOrPabTransferRequest.getExpiredDate());

		return null;

	}

	public IAccountTransferResponse transfer(
			IAccountPaidTransferRequest accountPaidTransferRequest) {

		// ת��ƾ֤
		TblActTransferVoucher tblActTransferVoucher = new TblActTransferVoucher();

		tblActTransferVoucher.setVoucherNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());
		tblActTransferVoucher.setActAccountFrom(tblActAccountBalanceMgr
				.getActAccountById(accountPaidTransferRequest
						.getAccountIdFrom()));
		tblActTransferVoucher
				.setActAccountTo(tblActAccountBalanceMgr
						.getActAccountById(accountPaidTransferRequest
								.getAccountIdTo()));

		tblActTransferVoucher.setAmount(accountPaidTransferRequest.getAmount());
		tblActTransferVoucher.setBizType(accountPaidTransferRequest
				.getBizType());
		tblActTransferVoucher.setBizLogId(accountPaidTransferRequest
				.getBizLogId());
		tblActTransferVoucher.setRemark(accountPaidTransferRequest.getRemark());

		tblActTransferVoucherMgr
				.saveTblActTransferVoucher(tblActTransferVoucher);

		// ����֮ǰ��Ӧ��״̬
		TblActAccountDetail tblActAccountDetail = (TblActAccountDetail) tblActAccountDetailMgr
				.getObjects(
						FilterFactory
								.getSimpleFilter("bizLogId",
										accountPaidTransferRequest
												.getRelatedBizLogId(),
										Filter.OPERATOR_EQ)).get(0);
		tblActAccountDetail.setSettleStatus(SettleStatus.SETTLESTATUS_SETTLED);
		tblActAccountDetailMgr.saveObject(tblActAccountDetail);

		// ����
		credit(accountPaidTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo(), null);

		// ���
		debit(accountPaidTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo(), null);

		return null;

	}

	private void debit(IAccountTransferRequest accountTransferRequest,
			int voucherType, String voucherNo, String expiredDate) {
		charge(accountTransferRequest.getAccountIdTo(), accountTransferRequest
				.getAmount(), DebitOrCredit.DEBITORCREDIT_DEBIT, voucherType,
				voucherNo, accountTransferRequest.getRemark(), expiredDate);
	}

	public void credit(IAccountTransferRequest accountTransferRequest,
			int voucherType, String voucherNo, String expiredDate) {
		charge(accountTransferRequest.getAccountIdFrom(),
				accountTransferRequest.getAmount(),
				DebitOrCredit.DEBITORCREDIT_CREDIT, voucherType, voucherNo,
				accountTransferRequest.getRemark(), expiredDate);
	}

	public void charge(int accountId, int amount, int debitOrCredit,
			int voucherType, String voucherNo, String remark, String expiredDate) {

		// �˻����
		TblActAccountBalance tblActAccountBalance = tblActAccountBalanceMgr
				.getTblActAccountBalanceById(accountId);

		// ��Ϊ������Ϊ��
		int availableBalance = tblActAccountBalance.getAvailableBalance()
				+ amount
				* (debitOrCredit == DebitOrCredit.DEBITORCREDIT_DEBIT ? 1 : -1);

		if (availableBalance < 0) {
			throw new AccountException(EAccountResponse.E0001);
		}
		tblActAccountBalance.setAvailableBalance(availableBalance);
		tblActAccountBalanceMgr.saveTblActAccountBalance(tblActAccountBalance);

		// ��ϸ��
		TblActAccountDetail tblActAccountDetail = new TblActAccountDetail();
		tblActAccountDetail.setActAccount(tblActAccountBalanceMgr
				.getActAccountById(accountId));
		tblActAccountDetail.setVoucherType(voucherType);
		tblActAccountDetail.setVoucherNo(voucherNo);
		tblActAccountDetail.setAmount(amount);
		tblActAccountDetail.setDebitOrCredit(debitOrCredit);
		tblActAccountDetail.setBalance(tblActAccountBalance
				.getAvailableBalance());
		int settleStatus = SettleStatus.SETTLESTATUS_SETTLED;
		if (null == expiredDate) {
			expiredDate = DateUtils.format(new Date(), "yyyyMMdd");
			settleStatus = SettleStatus.SETTLESTATUS_SETTLED;
		} else {
			settleStatus = SettleStatus.SETTLESTATUS_TOSETTLED;
		}

		tblActAccountDetail.setExpiredDate(expiredDate);
		tblActAccountDetail.setSettleStatus(settleStatus);
		tblActAccountDetail.setRemark(remark);

		tblActAccountDetailMgr.saveTblActAccountDetail(tblActAccountDetail);

	}

	private int seq = 0;
	private final int MAX_PER_SECOND = 9999;

	private synchronized int getNextSeq() {
		seq++;
		seq %= MAX_PER_SECOND;
		return seq + 10000;
	}
}
