package org.hi.base.organization.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.organization.action.HiUserPageInfo;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;

public class HiUserListAction extends BaseAction{
	private HiUser hiUser;
	private HiUserPageInfo pageInfo;
	private List<HiUser> hiUsers;
	
	public String execute() throws Exception {
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		pageInfo = pageInfo == null ? new HiUserPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		hiUsers = hiUserMgr.getSecurityHiUserList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public HiUser getHiUser() {
		return hiUser;
	}

	public void setHiUser(HiUser hiUser) {
		this.hiUser = hiUser;
	}
	
	public List<HiUser> getHiUsers() {
		return hiUsers;
	}

	public void setHiUsers(List<HiUser> hiUsers) {
		this.hiUsers = hiUsers;
	}

	public HiUserPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HiUserPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
