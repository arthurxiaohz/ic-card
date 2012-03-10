package cn.net.iccard.special.service.impl;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.acegisecurity.providers.encoding.MessageDigestPasswordEncoder;
import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.base.organization.service.HiOrgManager;
import org.hi.base.sysapp.AppSettingHelper;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.dwz.service.RoleManager;

import cn.net.iccard.accounting.account.IAccountService;
import cn.net.iccard.accounting.account.impl.AccountService;
import cn.net.iccard.accounting.account.impl.SimpleAccountForOrgOpenRequest;

import cn.net.iccard.member.model.TblMbInfo;
import cn.net.iccard.member.service.TblMbInfoManager;
import cn.net.iccard.special.service.IMbInfoService;
import cn.net.iccard.tx.model.TblTxPayMentOrder;

public class MbInfoService implements IMbInfoService {

	private TblMbInfoManager tblMbInfoManager = (TblMbInfoManager) SpringContextHolder
			.getBean(TblMbInfo.class);

	private IAccountService accountService = (IAccountService) SpringContextHolder
	.getBean(AccountService.class);
	
	private RoleManager roleMgr = (RoleManager) SpringContextHolder
	.getBean(RoleManager.class);

private HiOrgManager hiOrgMgr = (HiOrgManager) SpringContextHolder
	.getBean(HiOrg.class);

	public boolean savePageAccountForMemeber(HttpServletRequest pageRequest) {

		//首先去线下平台查询用户信息
		
		//查询该用户是否已经开户
		Filter memberfilter = FilterFactory.getSimpleFilter("userName", pageRequest.getParameter("UserName"), Filter.OPERATOR_EQ);
		List<TblMbInfo> memberList  = tblMbInfoManager.getObjects(memberfilter);	
		
		if(memberList.size()>0){
			return false;
		}	
		
		// 记录开户信息
		TblMbInfo tblMbInfo = new TblMbInfo();
		tblMbInfo.setUserName(pageRequest.getParameter("UserName"));
		//tblMbInfo.setPassword(pageRequest.getParameter("Password"));
		tblMbInfo.setFullName(pageRequest.getParameter("FullName"));
		tblMbInfo.setCardNo(pageRequest.getParameter("cardNo"));
		tblMbInfo.setSSN(pageRequest.getParameter("SSN"));
		
		//tblMbInfo.setFullName(pageRequest.getParameter("FullName"));
		tblMbInfo.setUserMgrType(UserType.USERTYPE_MANAGER);
		tblMbInfo.setAccountEnabled(YesNo.YESNO_YES);
		tblMbInfo.setAccountLocked(YesNo.YESNO_NO);
		MessageDigestPasswordEncoder passwordEncoder = (MessageDigestPasswordEncoder) SpringContextHolder
		.getBean("passwordEncoder");

		tblMbInfo.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
		//tblMbInfo.setCreator((TblMbInfo)tblMbInfoManager.getObjectById(1));
		String password = passwordEncoder.encodePassword(pageRequest.getParameter("password"), null);
		tblMbInfo.setPassword(password);
		//tblMbInfoManager.saveTblMbInfo(tblMbInfo);
		
		// 会员
		int orgMember = Integer.parseInt(AppSettingHelper.getValue("CONSTANTS","ORG_MEMBER"));
		tblMbInfo.setOrg(hiOrgMgr.getHiOrgById(orgMember));

		tblMbInfoManager.saveTblMbInfo(tblMbInfo);

		//会员角色
		int roleMember = Integer.parseInt(AppSettingHelper.getValue(
				"CONSTANTS", "ROLE_MEMBER"));

		List<HiUser> users = new ArrayList<HiUser>();
		users.add(tblMbInfo);

		roleMgr.saveUserRole(roleMgr.getRoleById(roleMember), users);
		
		
		//记录账户信息
		SimpleAccountForOrgOpenRequest simpleAccountForOrgOpenRequest = new SimpleAccountForOrgOpenRequest();
		simpleAccountForOrgOpenRequest.setAccountName(pageRequest.getParameter("FullName"));
		simpleAccountForOrgOpenRequest.setAccountParty(pageRequest.getParameter("UserName"));
		simpleAccountForOrgOpenRequest.setAvailableBalance(0);
		simpleAccountForOrgOpenRequest.setRemark("open");
		accountService.openAccountForMember(simpleAccountForOrgOpenRequest);
		
		
		return true;
	}

	public DAO getDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getList(PageInfo arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Class getModelClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObjectById(Serializable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects(Filter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects(PageInfo arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects(Filter arg0, Sorter arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getObjects(Filter arg0, Sorter arg1, Page arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUniqueObject(Filter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeObject(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	public void removeObjectById(Serializable arg0) {
		// TODO Auto-generated method stub
		
	}

	public void saveObject(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setDAO(DAO arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
