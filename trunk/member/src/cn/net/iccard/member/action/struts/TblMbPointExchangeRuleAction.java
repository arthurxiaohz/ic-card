package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbPointExchangeRulePageInfo;
import cn.net.iccard.member.model.TblMbPointExchangeRule;
import cn.net.iccard.member.service.TblMbPointExchangeRuleManager;

public class TblMbPointExchangeRuleAction extends BaseAction{
	private TblMbPointExchangeRule tblMbPointExchangeRule;
	private TblMbPointExchangeRulePageInfo pageInfo;
	private List<TblMbPointExchangeRule> tblMbPointExchangeRules;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı����Ա���ֶһ�����
	 */
	public String saveTblMbPointExchangeRule() throws Exception {
		TblMbPointExchangeRuleManager tblMbPointExchangeRuleMgr = (TblMbPointExchangeRuleManager)SpringContextHolder.getBean(TblMbPointExchangeRule.class);
		if(super.perExecute(tblMbPointExchangeRule)!= null) return returnCommand();
		tblMbPointExchangeRuleMgr.saveTblMbPointExchangeRule(tblMbPointExchangeRule);
		super.postExecute(tblMbPointExchangeRule);
		return returnCommand();
	}
	
	
	/**
	 * ɾ����Ա���ֶһ�����
	 */
	public String removeTblMbPointExchangeRule() throws Exception {
		TblMbPointExchangeRuleManager tblMbPointExchangeRuleMgr = (TblMbPointExchangeRuleManager)SpringContextHolder.getBean(TblMbPointExchangeRule.class);
		tblMbPointExchangeRuleMgr.removeTblMbPointExchangeRuleById(tblMbPointExchangeRule.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ��Ա���ֶһ�����
	 */
	public String removeAllTblMbPointExchangeRule() throws Exception {
		TblMbPointExchangeRuleManager tblMbPointExchangeRuleMgr = (TblMbPointExchangeRuleManager)SpringContextHolder.getBean(TblMbPointExchangeRule.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbPointExchangeRuleid = new Integer( ids[i] );
				tblMbPointExchangeRuleMgr.removeTblMbPointExchangeRuleById(tblMbPointExchangeRuleid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴��Ա���ֶһ�����
	 */
	public String viewTblMbPointExchangeRule() throws Exception {
		TblMbPointExchangeRuleManager tblMbPointExchangeRuleMgr = (TblMbPointExchangeRuleManager)SpringContextHolder.getBean(TblMbPointExchangeRule.class);
		tblMbPointExchangeRule = tblMbPointExchangeRuleMgr.getTblMbPointExchangeRuleById(tblMbPointExchangeRule.getId());
		return returnCommand();
	}
	
	/**
	 * ��Ա���ֶһ������б�
	 */
	public String tblMbPointExchangeRuleList() throws Exception {
		TblMbPointExchangeRuleManager tblMbPointExchangeRuleMgr = (TblMbPointExchangeRuleManager)SpringContextHolder.getBean(TblMbPointExchangeRule.class);
		pageInfo = pageInfo == null ? new TblMbPointExchangeRulePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbPointExchangeRules = tblMbPointExchangeRuleMgr.getSecurityTblMbPointExchangeRuleList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbPointExchangeRule getTblMbPointExchangeRule() {
		return tblMbPointExchangeRule;
	}

	public void setTblMbPointExchangeRule(TblMbPointExchangeRule tblMbPointExchangeRule) {
		this.tblMbPointExchangeRule = tblMbPointExchangeRule;
	}
	
	public List<TblMbPointExchangeRule> getTblMbPointExchangeRules() {
		return tblMbPointExchangeRules;
	}

	public void setTblMbPointExchangeRules(List<TblMbPointExchangeRule> tblMbPointExchangeRules) {
		this.tblMbPointExchangeRules = tblMbPointExchangeRules;
	}

	public TblMbPointExchangeRulePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbPointExchangeRulePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
