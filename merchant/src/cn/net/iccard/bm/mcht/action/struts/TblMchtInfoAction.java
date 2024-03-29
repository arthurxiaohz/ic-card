package cn.net.iccard.bm.mcht.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.action.TblMchtInfoPageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.model.TblMchtUser;
import cn.net.iccard.bm.mcht.service.TblMchtInfoManager;
import cn.net.iccard.bm.mcht.service.TblMchtUserManager;

public class TblMchtInfoAction extends BaseAction{
	private TblMchtInfo tblMchtInfo;
	private TblMchtInfoPageInfo pageInfo;
	private List<TblMchtInfo> tblMchtInfos;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存商户
	 */
	public String saveTblMchtInfo() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager)SpringContextHolder.getBean(TblMchtInfo.class);
		if(super.perExecute(tblMchtInfo)!= null) return returnCommand();
		tblMchtInfoMgr.saveTblMchtInfo(tblMchtInfo);
		super.postExecute(tblMchtInfo);
		return returnCommand();
	}
	
	
	/**
	 * 删除商户
	 */
	public String removeTblMchtInfo() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager)SpringContextHolder.getBean(TblMchtInfo.class);
		tblMchtInfoMgr.removeTblMchtInfoById(tblMchtInfo.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些商户
	 */
	public String removeAllTblMchtInfo() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager)SpringContextHolder.getBean(TblMchtInfo.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMchtInfoid = new Integer( ids[i] );
				tblMchtInfoMgr.removeTblMchtInfoById(tblMchtInfoid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看商户
	 */
	public String viewTblMchtInfo() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager)SpringContextHolder.getBean(TblMchtInfo.class);
		tblMchtInfo = tblMchtInfoMgr.getTblMchtInfoById(tblMchtInfo.getId());
		return returnCommand();
	}
	
	/**
	 * 商户列表
	 */
	public String tblMchtInfoList() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager)SpringContextHolder.getBean(TblMchtInfo.class);
		pageInfo = pageInfo == null ? new TblMchtInfoPageInfo() : pageInfo;
		
		//锁定查询所属商户
		TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager) SpringContextHolder
				.getBean(TblMchtUser.class);
		pageInfo.setF_mchtNo(tblMchtUserMgr.getTblMchtUserById(
				(org.hi.framework.security.context.UserContextHelper.getUser()
						.getId())).getMchtNo());
		
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMchtInfos = tblMchtInfoMgr.getSecurityTblMchtInfoList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMchtInfo getTblMchtInfo() {
		return tblMchtInfo;
	}

	public void setTblMchtInfo(TblMchtInfo tblMchtInfo) {
		this.tblMchtInfo = tblMchtInfo;
	}
	
	public List<TblMchtInfo> getTblMchtInfos() {
		return tblMchtInfos;
	}

	public void setTblMchtInfos(List<TblMchtInfo> tblMchtInfos) {
		this.tblMchtInfos = tblMchtInfos;
	}

	public TblMchtInfoPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMchtInfoPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
