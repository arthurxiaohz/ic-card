package org.hi.i18n.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.i18n.action.LanguageStrPageInfo;
import org.hi.i18n.model.LanguageStr;
import org.hi.i18n.service.LanguageStrManager;

public class LanguageStrAction extends BaseAction{
	private LanguageStr languageStr;
	private LanguageStrPageInfo pageInfo;
	private List<LanguageStr> languageStrs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存多语言值
	 */
	public String saveLanguageStr() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		if(super.perExecute(languageStr)!= null) return returnCommand();
		languageStrMgr.saveLanguageStr(languageStr);
		super.postExecute(languageStr);
		return returnCommand();
	}
	
	
	/**
	 * 删除多语言值
	 */
	public String removeLanguageStr() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		languageStrMgr.removeLanguageStrById(languageStr.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些多语言值
	 */
	public String removeAllLanguageStr() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer languageStrid = new Integer( ids[i] );
				languageStrMgr.removeLanguageStrById(languageStrid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看多语言值
	 */
	public String viewLanguageStr() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		languageStr = languageStrMgr.getLanguageStrById(languageStr.getId());
		return returnCommand();
	}
	
	/**
	 * 多语言值列表
	 */
	public String languageStrList() throws Exception {
		LanguageStrManager languageStrMgr = (LanguageStrManager)SpringContextHolder.getBean(LanguageStr.class);
		pageInfo = pageInfo == null ? new LanguageStrPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		languageStrs = languageStrMgr.getLanguageStrList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public LanguageStr getLanguageStr() {
		return languageStr;
	}

	public void setLanguageStr(LanguageStr languageStr) {
		this.languageStr = languageStr;
	}
	
	public List<LanguageStr> getLanguageStrs() {
		return languageStrs;
	}

	public void setLanguageStrs(List<LanguageStr> languageStrs) {
		this.languageStrs = languageStrs;
	}

	public LanguageStrPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(LanguageStrPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
