package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.base.organization.service.HiUserManager;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.service.UserAuthorityManager;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.SynchronizationData;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.util.I18NUtil;

public class UserAuthoritySingleBatchSaveAction extends BaseAction implements SynchronizationData{
	private List<UserAuthority> userAuthorities;
	private String userAuthorityIndex;
	private HiUser user = null;
	public String execute() throws Exception {
		if(super.perExecute(null)!= null) return returnCommand();
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		if(userAuthorityIndex == null || userAuthorityIndex.length()<= 0 )
			return returnCommand();
		
		String[] indexs= userAuthorityIndex.split(",");
		
		if(user.getUserMgrType() == UserType.USERTYPE_ADMINISTRATOR)
			throw new BusinessException(I18NUtil.getStringByParameter("超级管理员无需授权", user.getFullName()));
		
		userAuthorityMgr.saveBatchSingleUserAuthority(indexs, userAuthorities,user);
		super.postExecute(null);
		return returnCommand();
	}


	public String getUserAuthorityIndex() {
		return userAuthorityIndex;
	}

	public void setUserAuthorityIndex(String userAuthorityIndex) {
		this.userAuthorityIndex = userAuthorityIndex;
	}

	public HiUser getUser() {
		return user;
	}

	public void setUser(HiUser user) {
		this.user = user;
	}


	public List<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}


	public void setUserAuthorities(List<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}


	

}
