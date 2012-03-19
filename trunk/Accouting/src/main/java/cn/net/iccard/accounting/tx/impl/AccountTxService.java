package cn.net.iccard.accounting.tx.impl;

import java.util.Date;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.accounting.AccountException;
import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.tx.IAccountDebitCreditRequest;
import cn.net.iccard.accounting.tx.IAccountDebitCreditResponse;
import cn.net.iccard.accounting.tx.IAccountPayableCancelTransferRequest;
import cn.net.iccard.accounting.tx.IAccountPayableTransferRequest;
import cn.net.iccard.accounting.tx.IAccountTransferRequest;
import cn.net.iccard.accounting.tx.IAccountTransferResponse;
import cn.net.iccard.accounting.tx.IAccountTxService;
import cn.net.iccard.bm.accounting.model.BizType;
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

		// 转账凭证
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

		// 贷记
		credit(accountTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo(), null);

		// 借记
		debit(accountTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo(), null);

		return new AccountTransferResponse(EAccountResponse.S0000,
				tblActTransferVoucher.getVoucherNo());

	}

	public IAccountTransferResponse transfer(
			IAccountPayableTransferRequest accountRcvOrPabTransferRequest) {

		// 转账凭证
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

		// 贷记
		credit(accountRcvOrPabTransferRequest,
				VoucherType.VOUCHERTYPE_TRANSFER, tblActTransferVoucher
						.getVoucherNo(), null);

		// 借记
		debit(accountRcvOrPabTransferRequest, VoucherType.VOUCHERTYPE_TRANSFER,
				tblActTransferVoucher.getVoucherNo(),
				accountRcvOrPabTransferRequest.getExpiredDate());

		return new AccountTransferResponse(EAccountResponse.S0000,
				tblActTransferVoucher.getVoucherNo());

	}

	public IAccountTransferResponse transfer(
			IAccountPayableCancelTransferRequest accountPayableCancelTransferRequest) {

		// 转账凭证
		TblActTransferVoucher tblActTransferVoucher = new TblActTransferVoucher();

		tblActTransferVoucher.setVoucherNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());
		tblActTransferVoucher.setActAccountFrom(tblActAccountBalanceMgr
				.getActAccountById(accountPayableCancelTransferRequest
						.getAccountIdFrom()));
		tblActTransferVoucher.setActAccountTo(tblActAccountBalanceMgr
				.getActAccountById(accountPayableCancelTransferRequest
						.getAccountIdTo()));

		tblActTransferVoucher.setAmount(accountPayableCancelTransferRequest
				.getAmount());
		tblActTransferVoucher.setBizType(accountPayableCancelTransferRequest
				.getBizType());
		tblActTransferVoucher.setBizLogId(accountPayableCancelTransferRequest
				.getBizLogId());
		tblActTransferVoucher.setRemark(accountPayableCancelTransferRequest
				.getRemark());

		tblActTransferVoucherMgr
				.saveTblActTransferVoucher(tblActTransferVoucher);

		// 更新原账务处理的应付状态为已处理
		// 转账凭证
		TblActTransferVoucher tblActTransferVoucherOriginal = (TblActTransferVoucher) tblActTransferVoucherMgr
				.getObjects(
						FilterFactory.getSimpleFilter("bizType",
								BizType.BIZTYPE_PREPAID).addCondition(
								"bizLogId",
								accountPayableCancelTransferRequest
										.getRelatedBizLogId())).get(0);
		TblActAccountDetail tblActAccountDetail = (TblActAccountDetail) tblActAccountDetailMgr
				.getObjects(
						FilterFactory.getSimpleFilter("voucherType",
								VoucherType.VOUCHERTYPE_TRANSFER).addCondition(
								"voucherNo",
								tblActTransferVoucherOriginal.getVoucherNo()))
				.get(0);
		tblActAccountDetail.setSettleStatus(SettleStatus.SETTLESTATUS_SETTLED);
		tblActAccountDetailMgr.saveObject(tblActAccountDetail);

		// 贷记
		credit(accountPayableCancelTransferRequest,
				VoucherType.VOUCHERTYPE_TRANSFER, tblActTransferVoucher
						.getVoucherNo(), null);

		// 借记
		debit(accountPayableCancelTransferRequest,
				VoucherType.VOUCHERTYPE_TRANSFER, tblActTransferVoucher
						.getVoucherNo(), null);

		return new AccountTransferResponse(EAccountResponse.S0000,
				tblActTransferVoucher.getVoucherNo());

	}

	private void debit(IAccountTransferRequest accountTransferRequest,
			int voucherType, String voucherNo, String expiredDate) {
		charge(accountTransferRequest.getAccountIdTo(), accountTransferRequest
				.getAmount(), DebitOrCredit.DEBITORCREDIT_DEBIT, voucherType,
				voucherNo, accountTransferRequest.getRemark(), expiredDate);
	}

	private void credit(IAccountTransferRequest accountTransferRequest,
			int voucherType, String voucherNo, String expiredDate) {
		charge(accountTransferRequest.getAccountIdFrom(),
				accountTransferRequest.getAmount(),
				DebitOrCredit.DEBITORCREDIT_CREDIT, voucherType, voucherNo,
				accountTransferRequest.getRemark(), expiredDate);
	}

	public void charge(int accountId, int amount, int debitOrCredit,
			int voucherType, String voucherNo, String remark, String expiredDate) {

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
		tblActAccountDetail.setActAccount(tblActAccountBalanceMgr
				.getActAccountById(accountId));
		tblActAccountDetail.setVoucherType(voucherType);
		tblActAccountDetail.setVoucherNo(voucherNo);
		tblActAccountDetail.setAmount(amount);
		tblActAccountDetail.setDebitOrCredit(debitOrCredit);
		tblActAccountDetail.setBalance(tblActAccountBalance
				.getAvailableBalance());
		int settleStatus = SettleStatus.SETTLESTATUS_TOSETTLED;
		if (null == expiredDate) {
			expiredDate = DateUtils.format(new Date(), "yyyyMMdd");
			settleStatus = SettleStatus.SETTLESTATUS_SETTLED;
		}

		tblActAccountDetail.setExpiredDate(expiredDate);
		tblActAccountDetail.setSettleStatus(settleStatus);
		tblActAccountDetail.setRemark(remark);

		tblActAccountDetailMgr.saveTblActAccountDetail(tblActAccountDetail);

	}

	public IAccountDebitCreditResponse doSettle(int voucherType,
			int originalBizType, int originalBizLogId, int bizType, int bizLogId) {

		TblActAccountDetail tblActAccountDetail = null;
		if (voucherType == VoucherType.VOUCHERTYPE_DEBITORCREDIT) {
			// 借/贷凭证
			TblActDebitCreditVoucher tblActDebitCreditVoucher = (TblActDebitCreditVoucher) tblActDebitCreditVoucherMgr
					.getObjects(
							FilterFactory.getSimpleFilter("bizType",
									originalBizType).addCondition("bizLogId",
									originalBizLogId)).get(0);
			tblActAccountDetail = (TblActAccountDetail) tblActAccountDetailMgr
					.getObjects(
							FilterFactory.getSimpleFilter("voucherType",
									voucherType).addCondition("voucherNo",
									tblActDebitCreditVoucher.getVoucherNo()))
					.get(0);

		} else {
			// 转账凭证
			TblActTransferVoucher tblActTransferVoucher = (TblActTransferVoucher) tblActTransferVoucherMgr
					.getObjects(
							FilterFactory.getSimpleFilter("bizType",
									originalBizType).addCondition("bizLogId",
									originalBizLogId)).get(0);
			tblActAccountDetail = (TblActAccountDetail) tblActAccountDetailMgr
					.getObjects(
							FilterFactory.getSimpleFilter("voucherType",
									voucherType).addCondition("voucherNo",
									tblActTransferVoucher.getVoucherNo())).get(
							0);
		}

		tblActAccountDetail.setSettleStatus(SettleStatus.SETTLESTATUS_SETTLED);
		tblActAccountDetailMgr.saveObject(tblActAccountDetail);

		AccountDebitCreditRequest accountDebitCreditRequest = new AccountDebitCreditRequest();
		accountDebitCreditRequest.setAccountId(tblActAccountDetail
				.getActAccount().getId());
		accountDebitCreditRequest.setAmount(tblActAccountDetail.getAmount());
		accountDebitCreditRequest.setBizType(bizType);
		accountDebitCreditRequest.setBizLogId(bizLogId);
		if (tblActAccountDetail.getDebitOrCredit() == DebitOrCredit.DEBITORCREDIT_DEBIT) {
			// 生成贷记
			return credit(accountDebitCreditRequest);
		} else {
			// 生成借记
			return debit(accountDebitCreditRequest);
		}

	}

	private int seq = 0;
	private final int MAX_PER_SECOND = 9999;

	private synchronized int getNextSeq() {
		seq++;
		seq %= MAX_PER_SECOND;
		return seq + 10000;
	}
}
