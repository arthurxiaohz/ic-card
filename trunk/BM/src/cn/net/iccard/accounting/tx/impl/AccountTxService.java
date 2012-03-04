package cn.net.iccard.accounting.tx.impl;

import java.util.Date;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.springframework.transaction.annotation.Transactional;

import cn.net.iccard.accounting.AccountException;
import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.tx.IAccountDebitCreditRequest;
import cn.net.iccard.accounting.tx.IAccountDebitCreditResponse;
import cn.net.iccard.accounting.tx.IAccountTransferRequest;
import cn.net.iccard.accounting.tx.IAccountTransferResponse;
import cn.net.iccard.accounting.tx.IAccountTxService;
import cn.net.iccard.bm.accounting.model.DebitOrCredit;
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
	 * 借贷记
	 * 
	 * @param accountDebitCreditRequest
	 * @param debitOrCredit
	 * @return
	 */
	private IAccountDebitCreditResponse debitOrCredit(
			IAccountDebitCreditRequest accountDebitCreditRequest,
			int debitOrCredit) throws AccountException {

		// 借贷记凭证
		TblActDebitCreditVoucher tblActDebitCreditVoucher = new TblActDebitCreditVoucher();

		tblActDebitCreditVoucher.setVoucherNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());

		tblActDebitCreditVoucher.setTblActAccountInf(tblActAccountBalanceMgr
				.getTblActAccountInfById(accountDebitCreditRequest
						.getAccountId()));

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
						.getVoucherNo(), accountDebitCreditRequest.getRemark());

		return new AccountDebitCreditResponse(EAccountResponse.S0000,
				tblActDebitCreditVoucher.getVoucherNo());

	}

	public IAccountTransferResponse transfer(
			IAccountTransferRequest accountTransferRequest) {

		// 转账凭证
		TblActTransferVoucher tblActTransferVoucher = new TblActTransferVoucher();

		tblActTransferVoucher.setVoucherNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());
		tblActTransferVoucher.setTblActAccountInfFrom(tblActAccountBalanceMgr
				.getTblActAccountInfById(accountTransferRequest
						.getAccountIdFrom()));
		tblActTransferVoucher.setTblActAccountInfTo(tblActAccountBalanceMgr
				.getTblActAccountInfById(accountTransferRequest
						.getAccountIdTo()));

		tblActTransferVoucher.setAmount(accountTransferRequest.getAmount());
		tblActTransferVoucher.setBizType(accountTransferRequest.getBizType());
		tblActTransferVoucher.setBizLogId(accountTransferRequest.getBizLogId());
		tblActTransferVoucher.setRemark(accountTransferRequest.getRemark());

		tblActTransferVoucherMgr
				.saveTblActTransferVoucher(tblActTransferVoucher);

		// 借记

		debit(accountTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo());

		// 贷记

		credit(accountTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo());

		return null;

	}

	private void debit(IAccountTransferRequest accountTransferRequest,
			int voucherType, String voucherNo) {
		charge(accountTransferRequest.getAccountIdTo(), accountTransferRequest
				.getAmount(), DebitOrCredit.DEBITORCREDIT_DEBIT, voucherType,
				voucherNo, accountTransferRequest.getRemark());
	}

	public void credit(IAccountTransferRequest accountTransferRequest,
			int voucherType, String voucherNo) {
		charge(accountTransferRequest.getAccountIdFrom(),
				accountTransferRequest.getAmount(),
				DebitOrCredit.DEBITORCREDIT_CREDIT, voucherType, voucherNo,
				accountTransferRequest.getRemark());
	}

	@Transactional
	public void charge(int accountId, int amount, int debitOrCredit,
			int voucherType, String voucherNo, String remark) {

		// 账户余额
		TblActAccountBalance tblActAccountBalance = tblActAccountBalanceMgr
				.getTblActAccountBalanceById(accountId);

		// 借为正，贷为负
		int availableBalance = tblActAccountBalance.getAvailableBalance()
				+ amount
				* (debitOrCredit == DebitOrCredit.DEBITORCREDIT_DEBIT ? 1 : -1);

		if (availableBalance < 0) {
			throw new AccountException(EAccountResponse.E0001);
		}
		tblActAccountBalance.setAvailableBalance(availableBalance);
		tblActAccountBalanceMgr.saveTblActAccountBalance(tblActAccountBalance);

		// 明细账
		TblActAccountDetail tblActAccountDetail = new TblActAccountDetail();
		tblActAccountDetail.setTblActAccountInf(tblActAccountBalanceMgr
				.getTblActAccountInfById(accountId));
		tblActAccountDetail.setVoucherType(voucherType);
		tblActAccountDetail.setVoucherNo(voucherNo);
		tblActAccountDetail.setAmount(amount);
		tblActAccountDetail.setDebitOrCredit(debitOrCredit);
		tblActAccountDetail.setBalance(tblActAccountBalance
				.getAvailableBalance());
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
