package org.hi.i18n.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.i18n.action.LanguagePageInfo;
import org.hi.i18n.model.Language;
import org.hi.i18n.service.LanguageManager;

public class LanguageAction extends BaseAction{
	private Language language;
	private LanguagePageInfo pageInfo;
	private List<Language> languages;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存多语言信息
	 */
	public String saveLanguage() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		if(super.perExecute(language)!= null) return returnCommand();
		languageMgr.saveLanguage(language);
		super.postExecute(language);
		return returnCommand();
	}
	
	
	/**
	 * 删除多语言信息
	 */
	public String removeLanguage() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		languageMgr.removeLanguageById(language.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些多语言信息
	 */
	public String removeAllLanguage() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer languageid = new Integer( ids[i] );
				languageMgr.removeLanguageById(languageid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看多语言信息
	 */
	public String viewLanguage() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		language = languageMgr.getLanguageById(language.getId());
		return returnCommand();
	}
	
	/**
	 * 多语言信息列表
	 */
	public String languageList() throws Exception {
		LanguageManager languageMgr = (LanguageManager)SpringContextHolder.getBean(Language.class);
		pageInfo = pageInfo == null ? new LanguagePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		languages = languageMgr.getLanguageList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public LanguagePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(LanguagePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
