package org.hi.framework.security.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.service.UserAuthorityManager;

public class UserAuthorityRemoveAllAction extends BaseAction{
	private UserAuthority userAuthority;
	private String orderIndexs;
	
	public String execute() throws Exception {
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer userAuthorityid = new Integer( ids[i] );
				userAuthorityMgr.removeUserAuthorityById(userAuthorityid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public UserAuthority getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthority userAuthority) {
		this.userAuthority = userAuthority;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
