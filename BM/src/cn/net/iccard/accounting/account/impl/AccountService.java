package cn.net.iccard.accounting.account.impl;

import java.util.Date;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;

import cn.net.iccard.accounting.account.IAccountOpenRequest;
import cn.net.iccard.accounting.account.IAccountResponse;
import cn.net.iccard.accounting.account.IAccountService;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.model.TblActAcountInf;
import cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager;
import cn.net.iccard.bm.accounting.service.TblActAcountInfManager;

public class AccountService implements IAccountService {

	public IAccountResponse openAccount(IAccountOpenRequest accountOpenRequest) {
		TblActAcountInfManager tblActAcountInfMgr = (TblActAcountInfManager) SpringContextHolder
				.getBean(TblActAcountInf.class);
		TblActAcountInf tblActAcountInf = new TblActAcountInf();
		tblActAcountInf.setAccountNo(DateUtils.format(new Date(),
				"yyyyMMddHHmmss")
				+ getNextSeq());
		tblActAcountInf.setAccountCatalog(accountOpenRequest
				.getAccountCatalog());
		tblActAcountInf.setAccountPartyType(accountOpenRequest
				.getAccountPartyType());
		tblActAcountInf.setAccountParty(accountOpenRequest.getAccountParty());
		tblActAcountInf.setAccountName(accountOpenRequest.getAccountName());
		tblActAcountInf.setRemark(accountOpenRequest.getRemark());

		tblActAcountInfMgr.saveTblActAcountInf(tblActAcountInf);

		TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager) SpringContextHolder
				.getBean(TblActAccountBalance.class);
		
		TblActAccountBalance tblActAccountBalance = new TblActAccountBalance();
//		tblActAccountBalance.setTblActAccountInf(tblActAccountInf);
		
		
		tblActAccountBalanceMgr.saveTblActAccountBalance(tblActAccountBalance);

		return null;
	}

	private int seq = 100000;
	private final int MAX_PER_SECOND = 999999;

	private synchronized int getNextSeq() {
		seq++;
		seq %= MAX_PER_SECOND;
		return seq;
	}
}
