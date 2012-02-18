package org.hi.framework.security.action.webwork;

import java.util.ArrayList;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.model.UserType;
import org.hi.base.organization.service.HiUserManager;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.service.UserAuthorityManager;
import org.hi.framework.web.SynchronizationData;
import org.hi.framework.web.webwork.BaseAction;

public class UserAuthorityBatchSaveAction extends BaseAction  implements SynchronizationData {
	private List<UserAuthority> userAuthorities;
	private String userIndexs;
	
	public String execute() throws Exception {
		if(super.perExecute(null)!= null) return returnCommand();
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		
		if(userIndexs == null && userIndexs.length()<= 0 )
			return returnCommand();
		
		List<HiUser> users = new ArrayList<HiUser>();
		String[] ids= userIndexs.split(",");
		for( int i=0; i<ids.length; i++)
		{
			if (ids[i].length()>0)
			{
				Integer userid = new Integer( ids[i] );
				HiUser user = (HiUser)userMgr.getHiUserById(userid);
				
				if(user.getUserMgrType() != UserType.USERTYPE_ADMINISTRATOR)
					users.add(user);
			}
		}
		
		userAuthorityMgr.saveBatchUserAuthority(users, userAuthorities);
		super.postExecute(null);
		return returnCommand();
	}

	public List<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(List<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}

	public String getUserIndexs() {
		return userIndexs;
	}

	public void setUserIndexs(String userIndexs) {
		this.userIndexs = userIndexs;
	}

}
