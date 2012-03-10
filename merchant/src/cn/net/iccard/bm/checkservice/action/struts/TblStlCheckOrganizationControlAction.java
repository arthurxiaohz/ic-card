package cn.net.iccard.bm.checkservice.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.checkservice.action.TblStlCheckOrganizationControlPageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlCheckOrganizationControl;
import cn.net.iccard.bm.checkservice.service.TblStlCheckOrganizationControlManager;

public class TblStlCheckOrganizationControlAction extends BaseAction{
	private TblStlCheckOrganizationControl tblStlCheckOrganizationControl;
	private TblStlCheckOrganizationControlPageInfo pageInfo;
	private List<TblStlCheckOrganizationControl> tblStlCheckOrganizationControls;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存对账任务控制表
	 */
	public String saveTblStlCheckOrganizationControl() throws Exception {
		TblStlCheckOrganizationControlManager tblStlCheckOrganizationControlMgr = (TblStlCheckOrganizationControlManager)SpringContextHolder.getBean(TblStlCheckOrganizationControl.class);
		if(super.perExecute(tblStlCheckOrganizationControl)!= null) return returnCommand();
		tblStlCheckOrganizationControlMgr.saveTblStlCheckOrganizationControl(tblStlCheckOrganizationControl);
		super.postExecute(tblStlCheckOrganizationControl);
		return returnCommand();
	}
	
	
	/**
	 * 删除对账任务控制表
	 */
	public String removeTblStlCheckOrganizationControl() throws Exception {
		TblStlCheckOrganizationControlManager tblStlCheckOrganizationControlMgr = (TblStlCheckOrganizationControlManager)SpringContextHolder.getBean(TblStlCheckOrganizationControl.class);
		tblStlCheckOrganizationControlMgr.removeTblStlCheckOrganizationControlById(tblStlCheckOrganizationControl.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些对账任务控制表
	 */
	public String removeAllTblStlCheckOrganizationControl() throws Exception {
		TblStlCheckOrganizationControlManager tblStlCheckOrganizationControlMgr = (TblStlCheckOrganizationControlManager)SpringContextHolder.getBean(TblStlCheckOrganizationControl.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblStlCheckOrganizationControlid = new Integer( ids[i] );
				tblStlCheckOrganizationControlMgr.removeTblStlCheckOrganizationControlById(tblStlCheckOrganizationControlid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看对账任务控制表
	 */
	public String viewTblStlCheckOrganizationControl() throws Exception {
		TblStlCheckOrganizationControlManager tblStlCheckOrganizationControlMgr = (TblStlCheckOrganizationControlManager)SpringContextHolder.getBean(TblStlCheckOrganizationControl.class);
		tblStlCheckOrganizationControl = tblStlCheckOrganizationControlMgr.getTblStlCheckOrganizationControlById(tblStlCheckOrganizationControl.getId());
		return returnCommand();
	}
	
	/**
	 * 对账任务控制表列表
	 */
	public String tblStlCheckOrganizationControlList() throws Exception {
		TblStlCheckOrganizationControlManager tblStlCheckOrganizationControlMgr = (TblStlCheckOrganizationControlManager)SpringContextHolder.getBean(TblStlCheckOrganizationControl.class);
		pageInfo = pageInfo == null ? new TblStlCheckOrganizationControlPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblStlCheckOrganizationControls = tblStlCheckOrganizationControlMgr.getSecurityTblStlCheckOrganizationControlList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblStlCheckOrganizationControl getTblStlCheckOrganizationControl() {
		return tblStlCheckOrganizationControl;
	}

	public void setTblStlCheckOrganizationControl(TblStlCheckOrganizationControl tblStlCheckOrganizationControl) {
		this.tblStlCheckOrganizationControl = tblStlCheckOrganizationControl;
	}
	
	public List<TblStlCheckOrganizationControl> getTblStlCheckOrganizationControls() {
		return tblStlCheckOrganizationControls;
	}

	public void setTblStlCheckOrganizationControls(List<TblStlCheckOrganizationControl> tblStlCheckOrganizationControls) {
		this.tblStlCheckOrganizationControls = tblStlCheckOrganizationControls;
	}

	public TblStlCheckOrganizationControlPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblStlCheckOrganizationControlPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
