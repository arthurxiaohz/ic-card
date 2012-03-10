package cn.net.iccard.bm.mcht.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.action.TblMchtUserPageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtUser;
import cn.net.iccard.bm.mcht.service.TblMchtUserManager;

public class TblMchtUserAction extends BaseAction{
	private TblMchtUser tblMchtUser;
	private TblMchtUserPageInfo pageInfo;
	private List<TblMchtUser> tblMchtUsers;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存商服用户
	 */
	public String saveTblMchtUser() throws Exception {
		TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager)SpringContextHolder.getBean(TblMchtUser.class);
		if(super.perExecute(tblMchtUser)!= null) return returnCommand();
		tblMchtUserMgr.saveTblMchtUser(tblMchtUser);
		super.postExecute(tblMchtUser);
		return returnCommand();
	}
	
	
	/**
	 * 删除商服用户
	 */
	public String removeTblMchtUser() throws Exception {
		TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager)SpringContextHolder.getBean(TblMchtUser.class);
		tblMchtUserMgr.removeTblMchtUserById(tblMchtUser.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些商服用户
	 */
	public String removeAllTblMchtUser() throws Exception {
		TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager)SpringContextHolder.getBean(TblMchtUser.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMchtUserid = new Integer( ids[i] );
				tblMchtUserMgr.removeTblMchtUserById(tblMchtUserid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看商服用户
	 */
	public String viewTblMchtUser() throws Exception {
		TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager)SpringContextHolder.getBean(TblMchtUser.class);
		tblMchtUser = tblMchtUserMgr.getTblMchtUserById(tblMchtUser.getId());
		return returnCommand();
	}
	
	/**
	 * 商服用户列表
	 */
	public String tblMchtUserList() throws Exception {
		TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager)SpringContextHolder.getBean(TblMchtUser.class);
		pageInfo = pageInfo == null ? new TblMchtUserPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMchtUsers = tblMchtUserMgr.getSecurityTblMchtUserList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMchtUser getTblMchtUser() {
		return tblMchtUser;
	}

	public void setTblMchtUser(TblMchtUser tblMchtUser) {
		this.tblMchtUser = tblMchtUser;
	}
	
	public List<TblMchtUser> getTblMchtUsers() {
		return tblMchtUsers;
	}

	public void setTblMchtUsers(List<TblMchtUser> tblMchtUsers) {
		this.tblMchtUsers = tblMchtUsers;
	}

	public TblMchtUserPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMchtUserPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
