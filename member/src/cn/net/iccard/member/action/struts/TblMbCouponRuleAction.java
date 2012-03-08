package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbCouponRulePageInfo;
import cn.net.iccard.member.model.TblMbCouponRule;
import cn.net.iccard.member.service.TblMbCouponRuleManager;

public class TblMbCouponRuleAction extends BaseAction{
	private TblMbCouponRule tblMbCouponRule;
	private TblMbCouponRulePageInfo pageInfo;
	private List<TblMbCouponRule> tblMbCouponRules;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存会员优惠券规则
	 */
	public String saveTblMbCouponRule() throws Exception {
		TblMbCouponRuleManager tblMbCouponRuleMgr = (TblMbCouponRuleManager)SpringContextHolder.getBean(TblMbCouponRule.class);
		if(super.perExecute(tblMbCouponRule)!= null) return returnCommand();
		tblMbCouponRuleMgr.saveTblMbCouponRule(tblMbCouponRule);
		super.postExecute(tblMbCouponRule);
		return returnCommand();
	}
	
	
	/**
	 * 删除会员优惠券规则
	 */
	public String removeTblMbCouponRule() throws Exception {
		TblMbCouponRuleManager tblMbCouponRuleMgr = (TblMbCouponRuleManager)SpringContextHolder.getBean(TblMbCouponRule.class);
		tblMbCouponRuleMgr.removeTblMbCouponRuleById(tblMbCouponRule.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些会员优惠券规则
	 */
	public String removeAllTblMbCouponRule() throws Exception {
		TblMbCouponRuleManager tblMbCouponRuleMgr = (TblMbCouponRuleManager)SpringContextHolder.getBean(TblMbCouponRule.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbCouponRuleid = new Integer( ids[i] );
				tblMbCouponRuleMgr.removeTblMbCouponRuleById(tblMbCouponRuleid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看会员优惠券规则
	 */
	public String viewTblMbCouponRule() throws Exception {
		TblMbCouponRuleManager tblMbCouponRuleMgr = (TblMbCouponRuleManager)SpringContextHolder.getBean(TblMbCouponRule.class);
		tblMbCouponRule = tblMbCouponRuleMgr.getTblMbCouponRuleById(tblMbCouponRule.getId());
		return returnCommand();
	}
	
	/**
	 * 会员优惠券规则列表
	 */
	public String tblMbCouponRuleList() throws Exception {
		TblMbCouponRuleManager tblMbCouponRuleMgr = (TblMbCouponRuleManager)SpringContextHolder.getBean(TblMbCouponRule.class);
		pageInfo = pageInfo == null ? new TblMbCouponRulePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbCouponRules = tblMbCouponRuleMgr.getSecurityTblMbCouponRuleList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbCouponRule getTblMbCouponRule() {
		return tblMbCouponRule;
	}

	public void setTblMbCouponRule(TblMbCouponRule tblMbCouponRule) {
		this.tblMbCouponRule = tblMbCouponRule;
	}
	
	public List<TblMbCouponRule> getTblMbCouponRules() {
		return tblMbCouponRules;
	}

	public void setTblMbCouponRules(List<TblMbCouponRule> tblMbCouponRules) {
		this.tblMbCouponRules = tblMbCouponRules;
	}

	public TblMbCouponRulePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbCouponRulePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
