package cn.net.iccard.bm.mcht.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.action.TblMchtCertificatePageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtCertificate;
import cn.net.iccard.bm.mcht.service.TblMchtCertificateManager;

public class TblMchtCertificateAction extends BaseAction{
	private TblMchtCertificate tblMchtCertificate;
	private TblMchtCertificatePageInfo pageInfo;
	private List<TblMchtCertificate> tblMchtCertificates;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存商户证书
	 */
	public String saveTblMchtCertificate() throws Exception {
		TblMchtCertificateManager tblMchtCertificateMgr = (TblMchtCertificateManager)SpringContextHolder.getBean(TblMchtCertificate.class);
		if(super.perExecute(tblMchtCertificate)!= null) return returnCommand();
		tblMchtCertificateMgr.saveTblMchtCertificate(tblMchtCertificate);
		super.postExecute(tblMchtCertificate);
		return returnCommand();
	}
	
	
	/**
	 * 删除商户证书
	 */
	public String removeTblMchtCertificate() throws Exception {
		TblMchtCertificateManager tblMchtCertificateMgr = (TblMchtCertificateManager)SpringContextHolder.getBean(TblMchtCertificate.class);
		tblMchtCertificateMgr.removeTblMchtCertificateById(tblMchtCertificate.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些商户证书
	 */
	public String removeAllTblMchtCertificate() throws Exception {
		TblMchtCertificateManager tblMchtCertificateMgr = (TblMchtCertificateManager)SpringContextHolder.getBean(TblMchtCertificate.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMchtCertificateid = new Integer( ids[i] );
				tblMchtCertificateMgr.removeTblMchtCertificateById(tblMchtCertificateid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看商户证书
	 */
	public String viewTblMchtCertificate() throws Exception {
		TblMchtCertificateManager tblMchtCertificateMgr = (TblMchtCertificateManager)SpringContextHolder.getBean(TblMchtCertificate.class);
		tblMchtCertificate = tblMchtCertificateMgr.getTblMchtCertificateById(tblMchtCertificate.getId());
		return returnCommand();
	}
	
	/**
	 * 商户证书列表
	 */
	public String tblMchtCertificateList() throws Exception {
		TblMchtCertificateManager tblMchtCertificateMgr = (TblMchtCertificateManager)SpringContextHolder.getBean(TblMchtCertificate.class);
		pageInfo = pageInfo == null ? new TblMchtCertificatePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMchtCertificates = tblMchtCertificateMgr.getSecurityTblMchtCertificateList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMchtCertificate getTblMchtCertificate() {
		return tblMchtCertificate;
	}

	public void setTblMchtCertificate(TblMchtCertificate tblMchtCertificate) {
		this.tblMchtCertificate = tblMchtCertificate;
	}
	
	public List<TblMchtCertificate> getTblMchtCertificates() {
		return tblMchtCertificates;
	}

	public void setTblMchtCertificates(List<TblMchtCertificate> tblMchtCertificates) {
		this.tblMchtCertificates = tblMchtCertificates;
	}

	public TblMchtCertificatePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMchtCertificatePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
