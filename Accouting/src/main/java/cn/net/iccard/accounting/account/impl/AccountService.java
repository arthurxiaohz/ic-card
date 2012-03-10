package cn.net.iccard.accounting.account.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.acegisecurity.providers.encoding.MessageDigestPasswordEncoder;
import org.apache.tools.ant.util.DateUtils;
import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.base.sysapp.AppSettingHelper;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.dwz.service.RoleManager;

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
import cn.net.iccard.bm.mcht.model.TblMchtUser;
import cn.net.iccard.bm.mcht.service.TblMchtUserManager;
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

	private TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager) SpringContextHolder
			.getBean(TblMchtUser.class);

	private RoleManager roleMgr = (RoleManager) SpringContextHolder
			.getBean(RoleManager.class);

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
		tblMbPointMgr.saveTblMbPoint(tblMbPoint);

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

		// 商户管理员
		TblMchtUser tblMchtUser = new TblMchtUser();
		tblMchtUser.setMchtNo(accountOpenForOrgRequest.getAccountParty());

		tblMchtUser.setUserName(accountOpenForOrgRequest.getAccountParty()
				+ "admin");
		tblMchtUser.setFullName(accountOpenForOrgRequest.getAccountParty()
				+ "admin");
		tblMchtUser.setUserMgrType(UserType.USERTYPE_MANAGER);
		tblMchtUser.setAccountEnabled(YesNo.YESNO_YES);
		tblMchtUser.setAccountLocked(YesNo.YESNO_NO);

		MessageDigestPasswordEncoder passwordEncoder = (MessageDigestPasswordEncoder) SpringContextHolder
				.getBean("passwordEncoder");
		// 初始默认密码，123456
		String password = passwordEncoder.encodePassword("123456", null);
		tblMchtUser.setPassword(password);
		tblMchtUserMgr.saveTblMchtUser(tblMchtUser);

		// 商户管理员角色
		int roleMerchant = Integer.parseInt(AppSettingHelper.getValue(
				"CONSTANTS", "ROLE_MERCHANT"));
		// 商户部门
		int orgMerchant = Integer.parseInt(AppSettingHelper.getValue(
				"CONSTANTS", "ORG_MERCHANT"));

		// 商户管理员
		List<HiUser> users = new ArrayList<HiUser>();
		users.add(tblMchtUser);

		roleMgr.saveUserRole(roleMgr.getRoleById(roleMerchant), orgMerchant,
				users);

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
