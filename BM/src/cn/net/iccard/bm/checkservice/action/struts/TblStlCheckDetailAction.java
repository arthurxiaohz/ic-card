package cn.net.iccard.bm.checkservice.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.checkservice.action.TblStlCheckDetailPageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlCheckDetail;
import cn.net.iccard.bm.checkservice.service.TblStlCheckDetailManager;

public class TblStlCheckDetailAction extends BaseAction{
	private TblStlCheckDetail tblStlCheckDetail;
	private TblStlCheckDetailPageInfo pageInfo;
	private List<TblStlCheckDetail> tblStlCheckDetails;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı��������ϸ��¼��
	 */
	public String saveTblStlCheckDetail() throws Exception {
		TblStlCheckDetailManager tblStlCheckDetailMgr = (TblStlCheckDetailManager)SpringContextHolder.getBean(TblStlCheckDetail.class);
		if(super.perExecute(tblStlCheckDetail)!= null) return returnCommand();
		tblStlCheckDetailMgr.saveTblStlCheckDetail(tblStlCheckDetail);
		super.postExecute(tblStlCheckDetail);
		return returnCommand();
	}
	
	
	/**
	 * ɾ��������ϸ��¼��
	 */
	public String removeTblStlCheckDetail() throws Exception {
		TblStlCheckDetailManager tblStlCheckDetailMgr = (TblStlCheckDetailManager)SpringContextHolder.getBean(TblStlCheckDetail.class);
		tblStlCheckDetailMgr.removeTblStlCheckDetailById(tblStlCheckDetail.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ������ϸ��¼��
	 */
	public String removeAllTblStlCheckDetail() throws Exception {
		TblStlCheckDetailManager tblStlCheckDetailMgr = (TblStlCheckDetailManager)SpringContextHolder.getBean(TblStlCheckDetail.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblStlCheckDetailid = new Integer( ids[i] );
				tblStlCheckDetailMgr.removeTblStlCheckDetailById(tblStlCheckDetailid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴������ϸ��¼��
	 */
	public String viewTblStlCheckDetail() throws Exception {
		TblStlCheckDetailManager tblStlCheckDetailMgr = (TblStlCheckDetailManager)SpringContextHolder.getBean(TblStlCheckDetail.class);
		tblStlCheckDetail = tblStlCheckDetailMgr.getTblStlCheckDetailById(tblStlCheckDetail.getId());
		return returnCommand();
	}
	
	/**
	 * ������ϸ��¼���б�
	 */
	public String tblStlCheckDetailList() throws Exception {
		TblStlCheckDetailManager tblStlCheckDetailMgr = (TblStlCheckDetailManager)SpringContextHolder.getBean(TblStlCheckDetail.class);
		pageInfo = pageInfo == null ? new TblStlCheckDetailPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblStlCheckDetails = tblStlCheckDetailMgr.getSecurityTblStlCheckDetailList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblStlCheckDetail getTblStlCheckDetail() {
		return tblStlCheckDetail;
	}

	public void setTblStlCheckDetail(TblStlCheckDetail tblStlCheckDetail) {
		this.tblStlCheckDetail = tblStlCheckDetail;
	}
	
	public List<TblStlCheckDetail> getTblStlCheckDetails() {
		return tblStlCheckDetails;
	}

	public void setTblStlCheckDetails(List<TblStlCheckDetail> tblStlCheckDetails) {
		this.tblStlCheckDetails = tblStlCheckDetails;
	}

	public TblStlCheckDetailPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblStlCheckDetailPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
