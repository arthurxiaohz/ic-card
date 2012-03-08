package cn.net.iccard.bm.mcht.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.action.TblMchtFeeConfigPageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtFeeConfig;
import cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager;

public class TblMchtFeeConfigAction extends BaseAction{
	private TblMchtFeeConfig tblMchtFeeConfig;
	private TblMchtFeeConfigPageInfo pageInfo;
	private List<TblMchtFeeConfig> tblMchtFeeConfigs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存商户手续费配置
	 */
	public String saveTblMchtFeeConfig() throws Exception {
		TblMchtFeeConfigManager tblMchtFeeConfigMgr = (TblMchtFeeConfigManager)SpringContextHolder.getBean(TblMchtFeeConfig.class);
		if(super.perExecute(tblMchtFeeConfig)!= null) return returnCommand();
		tblMchtFeeConfigMgr.saveTblMchtFeeConfig(tblMchtFeeConfig);
		super.postExecute(tblMchtFeeConfig);
		return returnCommand();
	}
	
	
	/**
	 * 删除商户手续费配置
	 */
	public String removeTblMchtFeeConfig() throws Exception {
		TblMchtFeeConfigManager tblMchtFeeConfigMgr = (TblMchtFeeConfigManager)SpringContextHolder.getBean(TblMchtFeeConfig.class);
		tblMchtFeeConfigMgr.removeTblMchtFeeConfigById(tblMchtFeeConfig.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些商户手续费配置
	 */
	public String removeAllTblMchtFeeConfig() throws Exception {
		TblMchtFeeConfigManager tblMchtFeeConfigMgr = (TblMchtFeeConfigManager)SpringContextHolder.getBean(TblMchtFeeConfig.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMchtFeeConfigid = new Integer( ids[i] );
				tblMchtFeeConfigMgr.removeTblMchtFeeConfigById(tblMchtFeeConfigid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看商户手续费配置
	 */
	public String viewTblMchtFeeConfig() throws Exception {
		TblMchtFeeConfigManager tblMchtFeeConfigMgr = (TblMchtFeeConfigManager)SpringContextHolder.getBean(TblMchtFeeConfig.class);
		tblMchtFeeConfig = tblMchtFeeConfigMgr.getTblMchtFeeConfigById(tblMchtFeeConfig.getId());
		return returnCommand();
	}
	
	/**
	 * 商户手续费配置列表
	 */
	public String tblMchtFeeConfigList() throws Exception {
		TblMchtFeeConfigManager tblMchtFeeConfigMgr = (TblMchtFeeConfigManager)SpringContextHolder.getBean(TblMchtFeeConfig.class);
		pageInfo = pageInfo == null ? new TblMchtFeeConfigPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMchtFeeConfigs = tblMchtFeeConfigMgr.getSecurityTblMchtFeeConfigList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMchtFeeConfig getTblMchtFeeConfig() {
		return tblMchtFeeConfig;
	}

	public void setTblMchtFeeConfig(TblMchtFeeConfig tblMchtFeeConfig) {
		this.tblMchtFeeConfig = tblMchtFeeConfig;
	}
	
	public List<TblMchtFeeConfig> getTblMchtFeeConfigs() {
		return tblMchtFeeConfigs;
	}

	public void setTblMchtFeeConfigs(List<TblMchtFeeConfig> tblMchtFeeConfigs) {
		this.tblMchtFeeConfigs = tblMchtFeeConfigs;
	}

	public TblMchtFeeConfigPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMchtFeeConfigPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
