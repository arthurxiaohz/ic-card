package cn.net.iccard.tx.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.tx.action.TblTxSmsLogPageInfo;
import cn.net.iccard.tx.model.TblTxSmsLog;
import cn.net.iccard.tx.service.TblTxSmsLogManager;

public class TblTxSmsLogAction extends BaseAction{
	private TblTxSmsLog tblTxSmsLog;
	private TblTxSmsLogPageInfo pageInfo;
	private List<TblTxSmsLog> tblTxSmsLogs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存短信明细
	 */
	public String saveTblTxSmsLog() throws Exception {
		TblTxSmsLogManager tblTxSmsLogMgr = (TblTxSmsLogManager)SpringContextHolder.getBean(TblTxSmsLog.class);
		if(super.perExecute(tblTxSmsLog)!= null) return returnCommand();
		tblTxSmsLogMgr.saveTblTxSmsLog(tblTxSmsLog);
		super.postExecute(tblTxSmsLog);
		return returnCommand();
	}
	
	
	/**
	 * 删除短信明细
	 */
	public String removeTblTxSmsLog() throws Exception {
		TblTxSmsLogManager tblTxSmsLogMgr = (TblTxSmsLogManager)SpringContextHolder.getBean(TblTxSmsLog.class);
		tblTxSmsLogMgr.removeTblTxSmsLogById(tblTxSmsLog.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些短信明细
	 */
	public String removeAllTblTxSmsLog() throws Exception {
		TblTxSmsLogManager tblTxSmsLogMgr = (TblTxSmsLogManager)SpringContextHolder.getBean(TblTxSmsLog.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblTxSmsLogid = new Integer( ids[i] );
				tblTxSmsLogMgr.removeTblTxSmsLogById(tblTxSmsLogid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看短信明细
	 */
	public String viewTblTxSmsLog() throws Exception {
		TblTxSmsLogManager tblTxSmsLogMgr = (TblTxSmsLogManager)SpringContextHolder.getBean(TblTxSmsLog.class);
		tblTxSmsLog = tblTxSmsLogMgr.getTblTxSmsLogById(tblTxSmsLog.getId());
		return returnCommand();
	}
	
	/**
	 * 短信明细列表
	 */
	public String tblTxSmsLogList() throws Exception {
		TblTxSmsLogManager tblTxSmsLogMgr = (TblTxSmsLogManager)SpringContextHolder.getBean(TblTxSmsLog.class);
		pageInfo = pageInfo == null ? new TblTxSmsLogPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblTxSmsLogs = tblTxSmsLogMgr.getSecurityTblTxSmsLogList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblTxSmsLog getTblTxSmsLog() {
		return tblTxSmsLog;
	}

	public void setTblTxSmsLog(TblTxSmsLog tblTxSmsLog) {
		this.tblTxSmsLog = tblTxSmsLog;
	}
	
	public List<TblTxSmsLog> getTblTxSmsLogs() {
		return tblTxSmsLogs;
	}

	public void setTblTxSmsLogs(List<TblTxSmsLog> tblTxSmsLogs) {
		this.tblTxSmsLogs = tblTxSmsLogs;
	}

	public TblTxSmsLogPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblTxSmsLogPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
