package cn.net.iccard.accounting.account.impl;

import java.util.Date;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.account.IAccountOpenRequest;
import cn.net.iccard.accounting.account.IAccountResponse;
import cn.net.iccard.accounting.account.IAccountService;
import cn.net.iccard.bm.accounting.model.AccountPartyType;
import cn.net.iccard.bm.accounting.model.AccountStatus;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager;
import cn.net.iccard.member.model.TblMbInfo;
import cn.net.iccard.member.model.TblMbPoint;
import cn.net.iccard.member.service.TblMbInfoManager;
import cn.net.iccard.member.service.TblMbPointManager;

public class AccountService implements IAccountService {

	private TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager) SpringContextHolder
			.getBean(TblActAccountBalance.class);

	private TblMbPointManager tblMbPointMgr = (TblMbPointManager) SpringContextHolder
			.getBean(TblMbPoint.class);

	private TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager) SpringContextHolder
			.getBean(TblMbInfo.class);

	public IAccountResponse openAccount(IAccountOpenRequest accountOpenRequest) {
		// TblActAccountInf��TblActAccountBalance��lookup��ϵ�޸�Ϊinheritance��ϵ

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

		if (accountOpenRequest.getAccountPartyType() == AccountPartyType.ACCOUNTPARTYTYPE_MEMBER) {
			TblMbPoint tblMbPoint = new TblMbPoint();
			tblMbPoint.setTblMbInfo((HiUser) tblMbInfoMgr.getObjects(
					FilterFactory.getSimpleFilter("userName",
							accountOpenRequest.getAccountParty(),
							Filter.OPERATOR_EQ)).get(0));
			tblMbPoint.setBalance(0);
			tblMbPointMgr.saveObject(tblMbPoint);
		}

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