package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.HelperFilter;
import org.hi.base.sysapp.model.Helper;
import org.hi.base.sysapp.service.HelperManager;
import org.hi.common.util.JSONObject;

public class HelperAction extends BaseAction{
	private Helper helper;
	private JSONObject json;
	
	/**
	 * 
	 */
	public String refHelper(){
		String url = (String)this.getSession().getAttribute(HelperFilter.SESSION_NAME_HELPER_LAST_URL);
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		Helper helper = helperMgr.getRefHelper(url);
		if(helper == null)
			json = new JSONObject("result", false);
		else{
			json = new JSONObject("result", true);
			String title = "";
			if(helper.getTitle() != null)
				title = helper.getTitle();
			json.addJSONObject("title", title);
		}
		return JSON;
		
	}

	public String showHelper(){
		String url = (String)this.getSession().getAttribute(HelperFilter.SESSION_NAME_HELPER_LAST_URL);
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		helper = helperMgr.getRefHelper(url);
		return AUTO;
	}

	public String linkHelper(){
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		helper = helperMgr.getLinkHelper(helper);
		
		this.setNextPage("/sysapp/showHelper.jsp");
		return NEXTPAGE;
	}
	
	public JSONObject getJson() {
		return json;
	}


	public void setJson(JSONObject json) {
		this.json = json;
	}
	
	
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
}
