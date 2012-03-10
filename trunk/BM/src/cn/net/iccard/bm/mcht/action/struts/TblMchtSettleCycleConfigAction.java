package cn.net.iccard.bm.mcht.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.action.TblMchtSettleCycleConfigPageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtSettleCycleConfig;
import cn.net.iccard.bm.mcht.service.TblMchtSettleCycleConfigManager;

public class TblMchtSettleCycleConfigAction extends BaseAction{
	private TblMchtSettleCycleConfig tblMchtSettleCycleConfig;
	private TblMchtSettleCycleConfigPageInfo pageInfo;
	private List<TblMchtSettleCycleConfig> tblMchtSettleCycleConfigs;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı����̻�������������
	 */
	public String saveTblMchtSettleCycleConfig() throws Exception {
		TblMchtSettleCycleConfigManager tblMchtSettleCycleConfigMgr = (TblMchtSettleCycleConfigManager)SpringContextHolder.getBean(TblMchtSettleCycleConfig.class);
		if(super.perExecute(tblMchtSettleCycleConfig)!= null) return returnCommand();
		tblMchtSettleCycleConfigMgr.saveTblMchtSettleCycleConfig(tblMchtSettleCycleConfig);
		super.postExecute(tblMchtSettleCycleConfig);
		return returnCommand();
	}
	
	
	/**
	 * ɾ���̻�������������
	 */
	public String removeTblMchtSettleCycleConfig() throws Exception {
		TblMchtSettleCycleConfigManager tblMchtSettleCycleConfigMgr = (TblMchtSettleCycleConfigManager)SpringContextHolder.getBean(TblMchtSettleCycleConfig.class);
		tblMchtSettleCycleConfigMgr.removeTblMchtSettleCycleConfigById(tblMchtSettleCycleConfig.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ�̻�������������
	 */
	public String removeAllTblMchtSettleCycleConfig() throws Exception {
		TblMchtSettleCycleConfigManager tblMchtSettleCycleConfigMgr = (TblMchtSettleCycleConfigManager)SpringContextHolder.getBean(TblMchtSettleCycleConfig.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMchtSettleCycleConfigid = new Integer( ids[i] );
				tblMchtSettleCycleConfigMgr.removeTblMchtSettleCycleConfigById(tblMchtSettleCycleConfigid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴�̻�������������
	 */
	public String viewTblMchtSettleCycleConfig() throws Exception {
		TblMchtSettleCycleConfigManager tblMchtSettleCycleConfigMgr = (TblMchtSettleCycleConfigManager)SpringContextHolder.getBean(TblMchtSettleCycleConfig.class);
		tblMchtSettleCycleConfig = tblMchtSettleCycleConfigMgr.getTblMchtSettleCycleConfigById(tblMchtSettleCycleConfig.getId());
		return returnCommand();
	}
	
	/**
	 * �̻��������������б�
	 */
	public String tblMchtSettleCycleConfigList() throws Exception {
		TblMchtSettleCycleConfigManager tblMchtSettleCycleConfigMgr = (TblMchtSettleCycleConfigManager)SpringContextHolder.getBean(TblMchtSettleCycleConfig.class);
		pageInfo = pageInfo == null ? new TblMchtSettleCycleConfigPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMchtSettleCycleConfigs = tblMchtSettleCycleConfigMgr.getSecurityTblMchtSettleCycleConfigList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMchtSettleCycleConfig getTblMchtSettleCycleConfig() {
		return tblMchtSettleCycleConfig;
	}

	public void setTblMchtSettleCycleConfig(TblMchtSettleCycleConfig tblMchtSettleCycleConfig) {
		this.tblMchtSettleCycleConfig = tblMchtSettleCycleConfig;
	}
	
	public List<TblMchtSettleCycleConfig> getTblMchtSettleCycleConfigs() {
		return tblMchtSettleCycleConfigs;
	}

	public void setTblMchtSettleCycleConfigs(List<TblMchtSettleCycleConfig> tblMchtSettleCycleConfigs) {
		this.tblMchtSettleCycleConfigs = tblMchtSettleCycleConfigs;
	}

	public TblMchtSettleCycleConfigPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMchtSettleCycleConfigPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
