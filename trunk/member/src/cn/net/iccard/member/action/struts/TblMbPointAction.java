package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbPointPageInfo;
import cn.net.iccard.member.model.TblMbPoint;
import cn.net.iccard.member.service.TblMbPointManager;

public class TblMbPointAction extends BaseAction{
	private TblMbPoint tblMbPoint;
	private TblMbPointPageInfo pageInfo;
	private List<TblMbPoint> tblMbPoints;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存会员积分
	 */
	public String saveTblMbPoint() throws Exception {
		TblMbPointManager tblMbPointMgr = (TblMbPointManager)SpringContextHolder.getBean(TblMbPoint.class);
		if(super.perExecute(tblMbPoint)!= null) return returnCommand();
		tblMbPointMgr.saveTblMbPoint(tblMbPoint);
		super.postExecute(tblMbPoint);
		return returnCommand();
	}
	
	
	/**
	 * 删除会员积分
	 */
	public String removeTblMbPoint() throws Exception {
		TblMbPointManager tblMbPointMgr = (TblMbPointManager)SpringContextHolder.getBean(TblMbPoint.class);
		tblMbPointMgr.removeTblMbPointById(tblMbPoint.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些会员积分
	 */
	public String removeAllTblMbPoint() throws Exception {
		TblMbPointManager tblMbPointMgr = (TblMbPointManager)SpringContextHolder.getBean(TblMbPoint.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbPointid = new Integer( ids[i] );
				tblMbPointMgr.removeTblMbPointById(tblMbPointid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看会员积分
	 */
	public String viewTblMbPoint() throws Exception {
		TblMbPointManager tblMbPointMgr = (TblMbPointManager)SpringContextHolder.getBean(TblMbPoint.class);
		tblMbPoint = tblMbPointMgr.getTblMbPointById(tblMbPoint.getId());
		return returnCommand();
	}
	
	/**
	 * 会员积分列表
	 */
	public String tblMbPointList() throws Exception {
		TblMbPointManager tblMbPointMgr = (TblMbPointManager)SpringContextHolder.getBean(TblMbPoint.class);
		pageInfo = pageInfo == null ? new TblMbPointPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbPoints = tblMbPointMgr.getSecurityTblMbPointList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbPoint getTblMbPoint() {
		return tblMbPoint;
	}

	public void setTblMbPoint(TblMbPoint tblMbPoint) {
		this.tblMbPoint = tblMbPoint;
	}
	
	public List<TblMbPoint> getTblMbPoints() {
		return tblMbPoints;
	}

	public void setTblMbPoints(List<TblMbPoint> tblMbPoints) {
		this.tblMbPoints = tblMbPoints;
	}

	public TblMbPointPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbPointPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
