package cn.net.iccard.accounting.account.impl;

import java.util.Date;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.account.IAccountOpenRequest;
import cn.net.iccard.accounting.account.IAccountResponse;
import cn.net.iccard.accounting.account.IAccountService;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.model.TblActAccountInf;
import cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager;
import cn.net.iccard.bm.accounting.service.TblActAccountInfManager;

public class AccountService implements IAccountService {

	public IAccountResponse openAccount(IAccountOpenRequest accountOpenRequest) {
		TblActAccountInfManager tblActAcountInfMgr = (TblActAccountInfManager) SpringContextHolder
				.getBean(TblActAccountInf.class);
		TblActAccountInf tblActAccountInf = new TblActAccountInf();
		tblActAccountInf.setAccountNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmssSSS")
				+ getNextSeq());
		tblActAccountInf.setAccountCatalog(accountOpenRequest
				.getAccountCatalog());
		tblActAccountInf.setAccountPartyType(accountOpenRequest
				.getAccountPartyType());
		tblActAccountInf.setAccountParty(accountOpenRequest.getAccountParty());
		tblActAccountInf.setAccountName(accountOpenRequest.getAccountName());
		tblActAccountInf.setRemark(accountOpenRequest.getRemark());

		tblActAcountInfMgr.saveTblActAccountInf(tblActAccountInf);

		TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager) SpringContextHolder
				.getBean(TblActAccountBalance.class);

		TblActAccountBalance tblActAccountBalance = new TblActAccountBalance();
		tblActAccountBalance.setTblActAccountInf(tblActAccountInf);
		tblActAccountBalance.setAvailableBalance(0);

		tblActAccountBalanceMgr.saveTblActAccountBalance(tblActAccountBalance);

		return new SimpleAccountOpenResponse(EAccountResponse.S0000,
				tblActAccountInf.getId(), tblActAccountInf.getAccountNo());
	}

	private int seq = 0;
	private final int MAX_PER_SECOND = 99;

	private synchronized int getNextSeq() {
		seq++;
		seq %= MAX_PER_SECOND;
		return seq + 100;
	}
}
