package cn.net.iccard.bm.mcht.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.action.TblMchtPaymentConfigPageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtPaymentConfig;
import cn.net.iccard.bm.mcht.service.TblMchtPaymentConfigManager;

public class TblMchtPaymentConfigAction extends BaseAction{
	private TblMchtPaymentConfig tblMchtPaymentConfig;
	private TblMchtPaymentConfigPageInfo pageInfo;
	private List<TblMchtPaymentConfig> tblMchtPaymentConfigs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存商户支付配置
	 */
	public String saveTblMchtPaymentConfig() throws Exception {
		TblMchtPaymentConfigManager tblMchtPaymentConfigMgr = (TblMchtPaymentConfigManager)SpringContextHolder.getBean(TblMchtPaymentConfig.class);
		if(super.perExecute(tblMchtPaymentConfig)!= null) return returnCommand();
		tblMchtPaymentConfigMgr.saveTblMchtPaymentConfig(tblMchtPaymentConfig);
		super.postExecute(tblMchtPaymentConfig);
		return returnCommand();
	}
	
	
	/**
	 * 删除商户支付配置
	 */
	public String removeTblMchtPaymentConfig() throws Exception {
		TblMchtPaymentConfigManager tblMchtPaymentConfigMgr = (TblMchtPaymentConfigManager)SpringContextHolder.getBean(TblMchtPaymentConfig.class);
		tblMchtPaymentConfigMgr.removeTblMchtPaymentConfigById(tblMchtPaymentConfig.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些商户支付配置
	 */
	public String removeAllTblMchtPaymentConfig() throws Exception {
		TblMchtPaymentConfigManager tblMchtPaymentConfigMgr = (TblMchtPaymentConfigManager)SpringContextHolder.getBean(TblMchtPaymentConfig.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMchtPaymentConfigid = new Integer( ids[i] );
				tblMchtPaymentConfigMgr.removeTblMchtPaymentConfigById(tblMchtPaymentConfigid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看商户支付配置
	 */
	public String viewTblMchtPaymentConfig() throws Exception {
		TblMchtPaymentConfigManager tblMchtPaymentConfigMgr = (TblMchtPaymentConfigManager)SpringContextHolder.getBean(TblMchtPaymentConfig.class);
		tblMchtPaymentConfig = tblMchtPaymentConfigMgr.getTblMchtPaymentConfigById(tblMchtPaymentConfig.getId());
		return returnCommand();
	}
	
	/**
	 * 商户支付配置列表
	 */
	public String tblMchtPaymentConfigList() throws Exception {
		TblMchtPaymentConfigManager tblMchtPaymentConfigMgr = (TblMchtPaymentConfigManager)SpringContextHolder.getBean(TblMchtPaymentConfig.class);
		pageInfo = pageInfo == null ? new TblMchtPaymentConfigPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMchtPaymentConfigs = tblMchtPaymentConfigMgr.getSecurityTblMchtPaymentConfigList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMchtPaymentConfig getTblMchtPaymentConfig() {
		return tblMchtPaymentConfig;
	}

	public void setTblMchtPaymentConfig(TblMchtPaymentConfig tblMchtPaymentConfig) {
		this.tblMchtPaymentConfig = tblMchtPaymentConfig;
	}
	
	public List<TblMchtPaymentConfig> getTblMchtPaymentConfigs() {
		return tblMchtPaymentConfigs;
	}

	public void setTblMchtPaymentConfigs(List<TblMchtPaymentConfig> tblMchtPaymentConfigs) {
		this.tblMchtPaymentConfigs = tblMchtPaymentConfigs;
	}

	public TblMchtPaymentConfigPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMchtPaymentConfigPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
