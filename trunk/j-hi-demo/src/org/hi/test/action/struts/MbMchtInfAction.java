package org.hi.test.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.test.action.MbMchtInfPageInfo;
import org.hi.test.model.MbMchtInf;
import org.hi.test.service.MbMchtInfManager;

public class MbMchtInfAction extends BaseAction{
	private MbMchtInf mbMchtInf;
	private MbMchtInfPageInfo pageInfo;
	private List<MbMchtInf> mbMchtInfs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存商户信息
	 */
	public String saveMbMchtInf() throws Exception {
		MbMchtInfManager mbMchtInfMgr = (MbMchtInfManager)SpringContextHolder.getBean(MbMchtInf.class);
		if(super.perExecute(mbMchtInf)!= null) return returnCommand();
		mbMchtInfMgr.saveMbMchtInf(mbMchtInf);
		super.postExecute(mbMchtInf);
		return returnCommand();
	}
	
	
	/**
	 * 删除商户信息
	 */
	public String removeMbMchtInf() throws Exception {
		MbMchtInfManager mbMchtInfMgr = (MbMchtInfManager)SpringContextHolder.getBean(MbMchtInf.class);
		mbMchtInfMgr.removeMbMchtInfById(mbMchtInf.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些商户信息
	 */
	public String removeAllMbMchtInf() throws Exception {
		MbMchtInfManager mbMchtInfMgr = (MbMchtInfManager)SpringContextHolder.getBean(MbMchtInf.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer mbMchtInfid = new Integer( ids[i] );
				mbMchtInfMgr.removeMbMchtInfById(mbMchtInfid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看商户信息
	 */
	public String viewMbMchtInf() throws Exception {
		MbMchtInfManager mbMchtInfMgr = (MbMchtInfManager)SpringContextHolder.getBean(MbMchtInf.class);
		mbMchtInf = mbMchtInfMgr.getMbMchtInfById(mbMchtInf.getId());
		return returnCommand();
	}
	
	/**
	 * 商户信息列表
	 */
	public String mbMchtInfList() throws Exception {
		MbMchtInfManager mbMchtInfMgr = (MbMchtInfManager)SpringContextHolder.getBean(MbMchtInf.class);
		pageInfo = pageInfo == null ? new MbMchtInfPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		mbMchtInfs = mbMchtInfMgr.getSecurityMbMchtInfList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public MbMchtInf getMbMchtInf() {
		return mbMchtInf;
	}

	public void setMbMchtInf(MbMchtInf mbMchtInf) {
		this.mbMchtInf = mbMchtInf;
	}
	
	public List<MbMchtInf> getMbMchtInfs() {
		return mbMchtInfs;
	}

	public void setMbMchtInfs(List<MbMchtInf> mbMchtInfs) {
		this.mbMchtInfs = mbMchtInfs;
	}

	public MbMchtInfPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(MbMchtInfPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
