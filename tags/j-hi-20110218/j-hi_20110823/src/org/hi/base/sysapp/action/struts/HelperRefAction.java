package org.hi.base.sysapp.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.sysapp.action.HelperRefPageInfo;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.base.sysapp.service.HelperRefManager;

public class HelperRefAction extends BaseAction{
	private HelperRef helperRef;
	private HelperRefPageInfo pageInfo;
	private List<HelperRef> helperRefs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存相关参考
	 */
	public String saveHelperRef() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		if(super.perExecute(helperRef)!= null) return returnCommand();
		helperRefMgr.saveHelperRef(helperRef);
		super.postExecute(helperRef);
		return returnCommand();
	}
	
	
	/**
	 * 删除相关参考
	 */
	public String removeHelperRef() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		helperRefMgr.removeHelperRefById(helperRef.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些相关参考
	 */
	public String removeAllHelperRef() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer helperRefid = new Integer( ids[i] );
				helperRefMgr.removeHelperRefById(helperRefid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看相关参考
	 */
	public String viewHelperRef() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		helperRef = helperRefMgr.getHelperRefById(helperRef.getId());
		return returnCommand();
	}
	
	/**
	 * 相关参考列表
	 */
	public String helperRefList() throws Exception {
		HelperRefManager helperRefMgr = (HelperRefManager)SpringContextHolder.getBean(HelperRef.class);
		pageInfo = pageInfo == null ? new HelperRefPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		helperRefs = helperRefMgr.getSecurityHelperRefList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public HelperRef getHelperRef() {
		return helperRef;
	}

	public void setHelperRef(HelperRef helperRef) {
		this.helperRef = helperRef;
	}
	
	public List<HelperRef> getHelperRefs() {
		return helperRefs;
	}

	public void setHelperRefs(List<HelperRef> helperRefs) {
		this.helperRefs = helperRefs;
	}

	public HelperRefPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HelperRefPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
