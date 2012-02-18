package org.hi.base.organization.action.webwork;

import java.util.List;

import org.acegisecurity.providers.encoding.MessageDigestPasswordEncoder;
import org.hi.SpringContextHolder;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.security.context.UserContext;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.SynchronizationData;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.i18n.util.I18NUtil;

public class PersonalSettingSaveAction extends BaseAction implements SynchronizationData{
	private HiUser hiUser;
	
	public String execute() throws Exception {
		if(super.perExecute(hiUser)!= null) return returnCommand();
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		
		Filter filter = FilterFactory.getSimpleFilter("userName", hiUser.getUserName(), Filter.OPERATOR_EQ);
		List<HiUser> users = hiUserMgr.getObjects(filter);
		if(users.size() >1)
			throw new BusinessException(I18NUtil.getString("帐号重复") + "!");
		
		
		
		MessageDigestPasswordEncoder passwordEncoder = (MessageDigestPasswordEncoder)SpringContextHolder.getBean("passwordEncoder");
		String newPassword = getRequest().getParameter("hiUser.newPassword");
		String password = passwordEncoder.encodePassword(newPassword, null);
		
		if(!newPassword.equals("") && !newPassword.equals(hiUser.getPassword())){
			hiUser.setPassword(password);
		}
		
		hiUserMgr.saveObject(hiUser);
		super.postExecute(hiUser);
		
//		如果用户为当前更新当前用户缓存中的数据
		HiUser currentUser = UserContextHelper.getUser();
		if(currentUser.getId().equals(hiUser.getId())){
			UserContext userContext = UserContextHelper.getUserContext();
			userContext.setUser(hiUser);
		}
		return returnCommand();
	}
	
	public HiUser getHiUser() {
		return hiUser;
	}

	public void setHiUser(HiUser hiUser) {
		this.hiUser = hiUser;
	}

}
