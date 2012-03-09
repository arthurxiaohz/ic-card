package cn.net.iccard.special.service.impl;


import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;

import cn.net.iccard.accounting.account.IAccountService;
import cn.net.iccard.accounting.account.impl.AccountService;
import cn.net.iccard.accounting.account.impl.SimpleAccountForOrgOpenRequest;

import cn.net.iccard.member.model.TblMbInfo;
import cn.net.iccard.member.service.TblMbInfoManager;
import cn.net.iccard.special.service.IMbInfoService;

public class MbInfoService implements IMbInfoService {

	private TblMbInfoManager tblMbInfoManager = (TblMbInfoManager) SpringContextHolder
			.getBean(TblMbInfo.class);

	private IAccountService accountService = (IAccountService) SpringContextHolder
	.getBean(AccountService.class);

	public boolean savePageAccountForMemeber(HttpServletRequest pageRequest) {

		//首先去线下平台查询用户信息
		
		// 记录开户信息
		TblMbInfo tblMbInfo = new TblMbInfo();
		tblMbInfo.setUserName(pageRequest.getParameter("UserName"));
		tblMbInfo.setPassword(pageRequest.getParameter("Password"));
		tblMbInfo.setFullName(pageRequest.getParameter("FullName"));
		tblMbInfo.setCardNo(pageRequest.getParameter("cardNo"));
		tblMbInfoManager.saveTblMbInfo(tblMbInfo);
		
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
