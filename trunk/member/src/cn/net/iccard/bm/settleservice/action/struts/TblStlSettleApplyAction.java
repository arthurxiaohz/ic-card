package cn.net.iccard.bm.settleservice.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.settleservice.action.TblStlSettleApplyPageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlSettleApply;
import cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager;

public class TblStlSettleApplyAction extends BaseAction{
	private TblStlSettleApply tblStlSettleApply;
	private TblStlSettleApplyPageInfo pageInfo;
	private List<TblStlSettleApply> tblStlSettleApplys;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存结算申请
	 */
	public String saveTblStlSettleApply() throws Exception {
		TblStlSettleApplyManager tblStlSettleApplyMgr = (TblStlSettleApplyManager)SpringContextHolder.getBean(TblStlSettleApply.class);
		if(super.perExecute(tblStlSettleApply)!= null) return returnCommand();
		tblStlSettleApplyMgr.saveTblStlSettleApply(tblStlSettleApply);
		super.postExecute(tblStlSettleApply);
		return returnCommand();
	}
	
	
	/**
	 * 删除结算申请
	 */
	public String removeTblStlSettleApply() throws Exception {
		TblStlSettleApplyManager tblStlSettleApplyMgr = (TblStlSettleApplyManager)SpringContextHolder.getBean(TblStlSettleApply.class);
		tblStlSettleApplyMgr.removeTblStlSettleApplyById(tblStlSettleApply.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些结算申请
	 */
	public String removeAllTblStlSettleApply() throws Exception {
		TblStlSettleApplyManager tblStlSettleApplyMgr = (TblStlSettleApplyManager)SpringContextHolder.getBean(TblStlSettleApply.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblStlSettleApplyid = new Integer( ids[i] );
				tblStlSettleApplyMgr.removeTblStlSettleApplyById(tblStlSettleApplyid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看结算申请
	 */
	public String viewTblStlSettleApply() throws Exception {
		TblStlSettleApplyManager tblStlSettleApplyMgr = (TblStlSettleApplyManager)SpringContextHolder.getBean(TblStlSettleApply.class);
		tblStlSettleApply = tblStlSettleApplyMgr.getTblStlSettleApplyById(tblStlSettleApply.getId());
		return returnCommand();
	}
	
	/**
	 * 结算申请列表
	 */
	public String tblStlSettleApplyList() throws Exception {
		TblStlSettleApplyManager tblStlSettleApplyMgr = (TblStlSettleApplyManager)SpringContextHolder.getBean(TblStlSettleApply.class);
		pageInfo = pageInfo == null ? new TblStlSettleApplyPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblStlSettleApplys = tblStlSettleApplyMgr.getSecurityTblStlSettleApplyList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblStlSettleApply getTblStlSettleApply() {
		return tblStlSettleApply;
	}

	public void setTblStlSettleApply(TblStlSettleApply tblStlSettleApply) {
		this.tblStlSettleApply = tblStlSettleApply;
	}
	
	public List<TblStlSettleApply> getTblStlSettleApplys() {
		return tblStlSettleApplys;
	}

	public void setTblStlSettleApplys(List<TblStlSettleApply> tblStlSettleApplys) {
		this.tblStlSettleApplys = tblStlSettleApplys;
	}

	public TblStlSettleApplyPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblStlSettleApplyPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
