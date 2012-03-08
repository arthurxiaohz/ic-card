package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbPointDetailPageInfo;
import cn.net.iccard.member.model.TblMbPointDetail;
import cn.net.iccard.member.service.TblMbPointDetailManager;

public class TblMbPointDetailAction extends BaseAction{
	private TblMbPointDetail tblMbPointDetail;
	private TblMbPointDetailPageInfo pageInfo;
	private List<TblMbPointDetail> tblMbPointDetails;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı����Ա������ϸ
	 */
	public String saveTblMbPointDetail() throws Exception {
		TblMbPointDetailManager tblMbPointDetailMgr = (TblMbPointDetailManager)SpringContextHolder.getBean(TblMbPointDetail.class);
		if(super.perExecute(tblMbPointDetail)!= null) return returnCommand();
		tblMbPointDetailMgr.saveTblMbPointDetail(tblMbPointDetail);
		super.postExecute(tblMbPointDetail);
		return returnCommand();
	}
	
	
	/**
	 * ɾ����Ա������ϸ
	 */
	public String removeTblMbPointDetail() throws Exception {
		TblMbPointDetailManager tblMbPointDetailMgr = (TblMbPointDetailManager)SpringContextHolder.getBean(TblMbPointDetail.class);
		tblMbPointDetailMgr.removeTblMbPointDetailById(tblMbPointDetail.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ��Ա������ϸ
	 */
	public String removeAllTblMbPointDetail() throws Exception {
		TblMbPointDetailManager tblMbPointDetailMgr = (TblMbPointDetailManager)SpringContextHolder.getBean(TblMbPointDetail.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbPointDetailid = new Integer( ids[i] );
				tblMbPointDetailMgr.removeTblMbPointDetailById(tblMbPointDetailid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴��Ա������ϸ
	 */
	public String viewTblMbPointDetail() throws Exception {
		TblMbPointDetailManager tblMbPointDetailMgr = (TblMbPointDetailManager)SpringContextHolder.getBean(TblMbPointDetail.class);
		tblMbPointDetail = tblMbPointDetailMgr.getTblMbPointDetailById(tblMbPointDetail.getId());
		return returnCommand();
	}
	
	/**
	 * ��Ա������ϸ�б�
	 */
	public String tblMbPointDetailList() throws Exception {
		TblMbPointDetailManager tblMbPointDetailMgr = (TblMbPointDetailManager)SpringContextHolder.getBean(TblMbPointDetail.class);
		pageInfo = pageInfo == null ? new TblMbPointDetailPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbPointDetails = tblMbPointDetailMgr.getSecurityTblMbPointDetailList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbPointDetail getTblMbPointDetail() {
		return tblMbPointDetail;
	}

	public void setTblMbPointDetail(TblMbPointDetail tblMbPointDetail) {
		this.tblMbPointDetail = tblMbPointDetail;
	}
	
	public List<TblMbPointDetail> getTblMbPointDetails() {
		return tblMbPointDetails;
	}

	public void setTblMbPointDetails(List<TblMbPointDetail> tblMbPointDetails) {
		this.tblMbPointDetails = tblMbPointDetails;
	}

	public TblMbPointDetailPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbPointDetailPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
