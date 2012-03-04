package cn.net.iccard.accounting.account.impl;

import java.util.Date;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.account.IAccountOpenRequest;
import cn.net.iccard.accounting.account.IAccountResponse;
import cn.net.iccard.accounting.account.IAccountService;
import cn.net.iccard.bm.accounting.model.AccountStatus;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager;

public class AccountService implements IAccountService {

	private TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager) SpringContextHolder
			.getBean(TblActAccountBalance.class);

	public IAccountResponse openAccount(IAccountOpenRequest accountOpenRequest) {
		// TblActAccountInf和TblActAccountBalance由lookup关系修改为inheritance关系

		// TblActAccountInfManager tblActAcountInfMgr =
		// (TblActAccountInfManager) SpringContextHolder
		// .getBean(TblActAccountInf.class);
		// TblActAccountInf tblActAccountInf = new TblActAccountInf();

		// tblActAcountInfMgr.saveTblActAccountInf(tblActAccountInf);

		TblActAccountBalance tblActAccountBalance = new TblActAccountBalance();
		// tblActAccountBalance.setTblActAccountInf(tblActAccountInf);
		tblActAccountBalance.setAccountNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());
		tblActAccountBalance.setAccountCatalog(accountOpenRequest
				.getAccountCatalog());
		tblActAccountBalance.setAccountPartyType(accountOpenRequest
				.getAccountPartyType());
		tblActAccountBalance.setAccountParty(accountOpenRequest
				.getAccountParty());
		tblActAccountBalance
				.setAccountName(accountOpenRequest.getAccountName());
		tblActAccountBalance.setStatus(AccountStatus.ACCOUNTSTATUS_NORMAL);
		tblActAccountBalance.setRemark(accountOpenRequest.getRemark());

		tblActAccountBalance.setAvailableBalance(accountOpenRequest
				.getAvailableBalance());

		tblActAccountBalanceMgr.saveTblActAccountBalance(tblActAccountBalance);

		return new SimpleAccountOpenResponse(EAccountResponse.S0000,
				tblActAccountBalance.getId(), tblActAccountBalance
						.getAccountNo());
	}

	private int seq = 0;
	private final int MAX_PER_SECOND = 99;

	private synchronized int getNextSeq() {
		seq++;
		seq %= MAX_PER_SECOND;
		return seq + 100;
	}
}
