package org.hi.base.enumeration.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.enumeration.action.EnumerationValuePageInfo;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.base.enumeration.service.EnumerationValueManager;

public class EnumerationValueAction extends BaseAction{
	private EnumerationValue enumerationValue;
	private EnumerationValuePageInfo pageInfo;
	private List<EnumerationValue> enumerationValues;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存枚举值
	 */
	public String saveEnumerationValue() throws Exception {
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		//判断
		if(super.perExecute(enumerationValue)!= null) return returnCommand();
		enumerationValueMgr.saveEnumerationValue(enumerationValue);
		super.postExecute(enumerationValue);
		return returnCommand();
	}
	
	
	/**
	 * 删除枚举值
	 */
	public String removeEnumerationValue() throws Exception {
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		enumerationValueMgr.removeEnumerationValueById(enumerationValue.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些枚举值
	 */
	public String removeAllEnumerationValue() throws Exception {
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer enumerationValueid = new Integer( ids[i] );
				enumerationValueMgr.removeEnumerationValueById(enumerationValueid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看枚举值
	 */
	public String viewEnumerationValue() throws Exception {
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		enumerationValue = enumerationValueMgr.getEnumerationValueById(enumerationValue.getId());
		return returnCommand();
	}
	
	/**
	 * 枚举值列表
	 */
	public String enumerationValueList() throws Exception {
		EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
		pageInfo = pageInfo == null ? new EnumerationValuePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		enumerationValues = enumerationValueMgr.getSecurityEnumerationValueList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	//get，set method
	public EnumerationValue getEnumerationValue() {
		return enumerationValue;
	}

	public void setEnumerationValue(EnumerationValue enumerationValue) {
		this.enumerationValue = enumerationValue;
	}
	
	public List<EnumerationValue> getEnumerationValues() {
		return enumerationValues;
	}

	public void setEnumerationValues(List<EnumerationValue> enumerationValues) {
		this.enumerationValues = enumerationValues;
	}

	public EnumerationValuePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(EnumerationValuePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
