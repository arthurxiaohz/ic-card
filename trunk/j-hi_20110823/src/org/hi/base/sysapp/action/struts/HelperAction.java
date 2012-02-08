package org.hi.base.sysapp.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;
import org.hi.i18n.util.I18NUtil;

import org.hi.base.sysapp.HelperFilter;
import org.hi.base.sysapp.action.HelperPageInfo;
import org.hi.base.sysapp.model.Helper;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.service.HelperManager;
import org.hi.common.util.JSONObject;

public class HelperAction extends BaseAction{
	private Helper helper;
	private HelperPageInfo pageInfo;
	private List<Helper> helpers;
	private String orderIndexs;
	private JSONObject json;
	
	/**
	 * 新增/修改保存辅助管理
	 */
	public String saveHelper() throws Exception {
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
	
	
	/**
	 * 删除辅助管理
	 */
	public String removeHelper() throws Exception {
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		helperMgr.removeHelperById(helper.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些辅助管理
	 */
	public String removeAllHelper() throws Exception {
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer helperid = new Integer( ids[i] );
				helperMgr.removeHelperById(helperid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看辅助管理
	 */
	public String viewHelper() throws Exception {
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		helper = helperMgr.getHelperById(helper.getId());
		return returnCommand();
	}
	
	/**
	 * 辅助管理列表
	 */
	public String helperList() throws Exception {
		HelperManager helperMgr = (HelperManager)SpringContextHolder.getBean(Helper.class);
		pageInfo = pageInfo == null ? new HelperPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		helpers = helperMgr.getSecurityHelperList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	
	public List<Helper> getHelpers() {
		return helpers;
	}

	public void setHelpers(List<Helper> helpers) {
		this.helpers = helpers;
	}

	public HelperPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HelperPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
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
	
	
	
}
