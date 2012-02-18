package org.hi.base.enumeration.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.enumeration.action.EnumerationPageInfo;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.service.EnumerationManager;
/**
 * 枚举实体类
 * @author User
 *
 */
public class EnumerationAction extends BaseAction{
	private Enumeration enumeration;
	private EnumerationPageInfo pageInfo;
	private List<Enumeration> enumerations;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存枚举实体
	 */
	public String saveEnumeration() throws Exception {
		//取得业务层接口
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		//如果数据被改写，返回success
		if(super.perExecute(enumeration)!= null) return returnCommand();
		//save
		enumerationMgr.saveEnumeration(enumeration);
		super.postExecute(enumeration);
		return returnCommand();
	}
	
	
	/**
	 * 删除枚举实体
	 */
	public String removeEnumeration() throws Exception {
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		enumerationMgr.removeEnumerationById(enumeration.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些枚举实体
	 */
	public String removeAllEnumeration() throws Exception {
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer enumerationid = new Integer( ids[i] );
				enumerationMgr.removeEnumerationById(enumerationid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看枚举实体
	 */
	public String viewEnumeration() throws Exception {
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		enumeration = enumerationMgr.getEnumerationById(enumeration.getId());
		return returnCommand();
	}
	
	/**
	 * 枚举实体列表
	 */
	public String enumerationList() throws Exception {
		EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
		pageInfo = pageInfo == null ? new EnumerationPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		enumerations = enumerationMgr.getSecurityEnumerationList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public Enumeration getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(Enumeration enumeration) {
		this.enumeration = enumeration;
	}
	
	public List<Enumeration> getEnumerations() {
		return enumerations;
	}

	public void setEnumerations(List<Enumeration> enumerations) {
		this.enumerations = enumerations;
	}

	public EnumerationPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(EnumerationPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
