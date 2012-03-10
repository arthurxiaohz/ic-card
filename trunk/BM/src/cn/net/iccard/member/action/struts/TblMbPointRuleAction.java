package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbPointRulePageInfo;
import cn.net.iccard.member.model.TblMbPointRule;
import cn.net.iccard.member.service.TblMbPointRuleManager;

public class TblMbPointRuleAction extends BaseAction{
	private TblMbPointRule tblMbPointRule;
	private TblMbPointRulePageInfo pageInfo;
	private List<TblMbPointRule> tblMbPointRules;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存积分规则
	 */
	public String saveTblMbPointRule() throws Exception {
		TblMbPointRuleManager tblMbPointRuleMgr = (TblMbPointRuleManager)SpringContextHolder.getBean(TblMbPointRule.class);
		if(super.perExecute(tblMbPointRule)!= null) return returnCommand();
		tblMbPointRuleMgr.saveTblMbPointRule(tblMbPointRule);
		super.postExecute(tblMbPointRule);
		return returnCommand();
	}
	
	
	/**
	 * 删除积分规则
	 */
	public String removeTblMbPointRule() throws Exception {
		TblMbPointRuleManager tblMbPointRuleMgr = (TblMbPointRuleManager)SpringContextHolder.getBean(TblMbPointRule.class);
		tblMbPointRuleMgr.removeTblMbPointRuleById(tblMbPointRule.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些积分规则
	 */
	public String removeAllTblMbPointRule() throws Exception {
		TblMbPointRuleManager tblMbPointRuleMgr = (TblMbPointRuleManager)SpringContextHolder.getBean(TblMbPointRule.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbPointRuleid = new Integer( ids[i] );
				tblMbPointRuleMgr.removeTblMbPointRuleById(tblMbPointRuleid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看积分规则
	 */
	public String viewTblMbPointRule() throws Exception {
		TblMbPointRuleManager tblMbPointRuleMgr = (TblMbPointRuleManager)SpringContextHolder.getBean(TblMbPointRule.class);
		tblMbPointRule = tblMbPointRuleMgr.getTblMbPointRuleById(tblMbPointRule.getId());
		return returnCommand();
	}
	
	/**
	 * 积分规则列表
	 */
	public String tblMbPointRuleList() throws Exception {
		TblMbPointRuleManager tblMbPointRuleMgr = (TblMbPointRuleManager)SpringContextHolder.getBean(TblMbPointRule.class);
		pageInfo = pageInfo == null ? new TblMbPointRulePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbPointRules = tblMbPointRuleMgr.getSecurityTblMbPointRuleList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbPointRule getTblMbPointRule() {
		return tblMbPointRule;
	}

	public void setTblMbPointRule(TblMbPointRule tblMbPointRule) {
		this.tblMbPointRule = tblMbPointRule;
	}
	
	public List<TblMbPointRule> getTblMbPointRules() {
		return tblMbPointRules;
	}

	public void setTblMbPointRules(List<TblMbPointRule> tblMbPointRules) {
		this.tblMbPointRules = tblMbPointRules;
	}

	public TblMbPointRulePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbPointRulePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
