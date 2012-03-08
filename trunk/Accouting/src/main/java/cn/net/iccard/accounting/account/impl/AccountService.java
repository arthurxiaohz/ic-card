package cn.net.iccard.accounting.account.impl;

import java.util.Date;

import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.ICommonAccountResponse;
import cn.net.iccard.accounting.account.IAccountOpenForOrgRequest;
import cn.net.iccard.accounting.account.IAccountOpenRequest;
import cn.net.iccard.accounting.account.IAccountOpenResponse;
import cn.net.iccard.accounting.account.IAccountService;
import cn.net.iccard.accounting.impl.SimpleCommonAccountResponse;
import cn.net.iccard.bm.accounting.model.AccountCatalog;
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

	public IAccountOpenResponse openAccount(
			IAccountOpenRequest accountOpenRequest) {
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

	public ICommonAccountResponse openAccountForMember(
			IAccountOpenForOrgRequest accountOpenForOrgRequest) {

		SimpleAccountOpenRequest simpleAccountOpenRequest = new SimpleAccountOpenRequest();
		// 会员虚拟账户
		simpleAccountOpenRequest
				.setAccountCatalog(AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT);
		simpleAccountOpenRequest
				.setAccountPartyType(AccountPartyType.ACCOUNTPARTYTYPE_MEMBER);
		simpleAccountOpenRequest.setAccountParty(accountOpenForOrgRequest
				.getAccountParty());
		simpleAccountOpenRequest.setAccountName(accountOpenForOrgRequest
				.getAccountName());
		openAccount(simpleAccountOpenRequest);

		// 会员担保账户
		simpleAccountOpenRequest
				.setAccountCatalog(AccountCatalog.ACCOUNTCATALOG_GUARANTEEACCOUNT);
		openAccount(simpleAccountOpenRequest);

		// 会员积分
		TblMbPoint tblMbPoint = new TblMbPoint();
		tblMbPoint.setTblMbInfo((HiUser) tblMbInfoMgr.getObjects(
				FilterFactory.getSimpleFilter("userName",
						accountOpenForOrgRequest.getAccountParty())).get(0));
		tblMbPoint.setBalance(0);
		tblMbPointMgr.saveObject(tblMbPoint);

		return new SimpleCommonAccountResponse(EAccountResponse.S0000);
	}

	public ICommonAccountResponse openAccountForMcht(
			IAccountOpenForOrgRequest accountOpenForOrgRequest) {

		SimpleAccountOpenRequest simpleAccountOpenRequest = new SimpleAccountOpenRequest();
		// 商户虚拟账户
		simpleAccountOpenRequest
				.setAccountCatalog(AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT);
		simpleAccountOpenRequest
				.setAccountPartyType(AccountPartyType.ACCOUNTPARTYTYPE_MCHT);
		simpleAccountOpenRequest.setAccountParty(accountOpenForOrgRequest
				.getAccountParty());
		simpleAccountOpenRequest.setAccountName(accountOpenForOrgRequest
				.getAccountName());
		openAccount(simpleAccountOpenRequest);

		// 商户手续费账户
		simpleAccountOpenRequest
				.setAccountCatalog(AccountCatalog.ACCOUNTCATALOG_FEEACCOUNT);
		openAccount(simpleAccountOpenRequest);
		return new SimpleCommonAccountResponse(EAccountResponse.S0000);
	}

	private int seq = 0;
	private final int MAX_PER_SECOND = 99;

	private synchronized int getNextSeq() {
		seq++;
		seq %= MAX_PER_SECOND;
		return seq + 100;
	}
}
