package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbInfoPageInfo;
import cn.net.iccard.member.model.TblMbInfo;
import cn.net.iccard.member.service.TblMbInfoManager;

public class TblMbInfoAction extends BaseAction{
	private TblMbInfo tblMbInfo;
	private TblMbInfoPageInfo pageInfo;
	private List<TblMbInfo> tblMbInfos;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存会员信息
	 */
	public String saveTblMbInfo() throws Exception {
		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
		if(super.perExecute(tblMbInfo)!= null) return returnCommand();
		tblMbInfoMgr.saveTblMbInfo(tblMbInfo);
		super.postExecute(tblMbInfo);
		return returnCommand();
	}
	
	
	/**
	 * 删除会员信息
	 */
	public String removeTblMbInfo() throws Exception {
		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
		tblMbInfoMgr.removeTblMbInfoById(tblMbInfo.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些会员信息
	 */
	public String removeAllTblMbInfo() throws Exception {
		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbInfoid = new Integer( ids[i] );
				tblMbInfoMgr.removeTblMbInfoById(tblMbInfoid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看会员信息
	 */
	public String viewTblMbInfo() throws Exception {
		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
		tblMbInfo = tblMbInfoMgr.getTblMbInfoById(tblMbInfo.getId());
		return returnCommand();
	}
	
	/**
	 * 会员信息列表
	 */
	public String tblMbInfoList() throws Exception {
		TblMbInfoManager tblMbInfoMgr = (TblMbInfoManager)SpringContextHolder.getBean(TblMbInfo.class);
		pageInfo = pageInfo == null ? new TblMbInfoPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbInfos = tblMbInfoMgr.getSecurityTblMbInfoList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbInfo getTblMbInfo() {
		return tblMbInfo;
	}

	public void setTblMbInfo(TblMbInfo tblMbInfo) {
		this.tblMbInfo = tblMbInfo;
	}
	
	public List<TblMbInfo> getTblMbInfos() {
		return tblMbInfos;
	}

	public void setTblMbInfos(List<TblMbInfo> tblMbInfos) {
		this.tblMbInfos = tblMbInfos;
	}

	public TblMbInfoPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbInfoPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
