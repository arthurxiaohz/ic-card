package org.hi.base.organization.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.organization.model.HiUser;
import org.hi.base.organization.service.HiUserManager;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.SynchronizationData;
import org.hi.i18n.util.I18NUtil;

public class HiUserSaveAction extends BaseAction implements SynchronizationData{
	private HiUser hiUser;
	
	public String execute() throws Exception {
		if(super.perExecute(hiUser)!= null) return returnCommand();
		HiUserManager hiUserMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
		
		Filter filter = FilterFactory.getSimpleFilter("userName", hiUser.getUserName(), Filter.OPERATOR_EQ);
		List<HiUser> users = hiUserMgr.getObjects(filter);
		if((hiUser.getId() == null && users.size() >0) || (hiUser.getId() != null && users.size() >1))
			throw new BusinessException(I18NUtil.getString("’ ∫≈÷ÿ∏¥") + "!");
		
		hiUserMgr.saveHiUser(hiUser);
		super.postExecute(hiUser);
		return returnCommand();
	}
	
	public HiUser getHiUser() {
		return hiUser;
	}

	public void setHiUser(HiUser hiUser) {
		this.hiUser = hiUser;
	}

}
