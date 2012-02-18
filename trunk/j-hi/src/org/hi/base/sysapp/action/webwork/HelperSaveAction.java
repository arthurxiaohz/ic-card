package org.hi.base.sysapp.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.sysapp.model.Helper;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.service.HelperManager;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.SynchronizationData;
import org.hi.i18n.util.I18NUtil;

public class HelperSaveAction extends BaseAction implements SynchronizationData{
	private Helper helper;
	
	public String execute() throws Exception {
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		if(helper.getId() != null && helper.getHelperRefs() != null){
			List<HelperRef> helperRefs = helper.getHelperRefs();
			for (HelperRef helperRef : helperRefs) {
				if(helperRef.getRefHelper().equals(helper))
					throw new BusinessException(I18NUtil.getString("相关参考不能引用自己", "Helper"));
			}
		}
		if(super.perExecute(helper)!= null) return returnCommand();
		helperMgr.saveHelper(helper);
		super.postExecute(helper);
		return returnCommand();
	}
	
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}

}
