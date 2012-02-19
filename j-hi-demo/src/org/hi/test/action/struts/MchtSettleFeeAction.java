package org.hi.test.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.test.action.MchtSettleFeePageInfo;
import org.hi.test.model.MchtSettleFee;
import org.hi.test.service.MchtSettleFeeManager;

public class MchtSettleFeeAction extends BaseAction{
	private MchtSettleFee mchtSettleFee;
	private MchtSettleFeePageInfo pageInfo;
	private List<MchtSettleFee> mchtSettleFees;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存商户手续费
	 */
	public String saveMchtSettleFee() throws Exception {
		MchtSettleFeeManager mchtSettleFeeMgr = (MchtSettleFeeManager)SpringContextHolder.getBean(MchtSettleFee.class);
		if(super.perExecute(mchtSettleFee)!= null) return returnCommand();
		mchtSettleFeeMgr.saveMchtSettleFee(mchtSettleFee);
		super.postExecute(mchtSettleFee);
		return returnCommand();
	}
	
	
	/**
	 * 删除商户手续费
	 */
	public String removeMchtSettleFee() throws Exception {
		MchtSettleFeeManager mchtSettleFeeMgr = (MchtSettleFeeManager)SpringContextHolder.getBean(MchtSettleFee.class);
		mchtSettleFeeMgr.removeMchtSettleFeeById(mchtSettleFee.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些商户手续费
	 */
	public String removeAllMchtSettleFee() throws Exception {
		MchtSettleFeeManager mchtSettleFeeMgr = (MchtSettleFeeManager)SpringContextHolder.getBean(MchtSettleFee.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer mchtSettleFeeid = new Integer( ids[i] );
				mchtSettleFeeMgr.removeMchtSettleFeeById(mchtSettleFeeid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看商户手续费
	 */
	public String viewMchtSettleFee() throws Exception {
		MchtSettleFeeManager mchtSettleFeeMgr = (MchtSettleFeeManager)SpringContextHolder.getBean(MchtSettleFee.class);
		mchtSettleFee = mchtSettleFeeMgr.getMchtSettleFeeById(mchtSettleFee.getId());
		return returnCommand();
	}
	
	/**
	 * 商户手续费列表
	 */
	public String mchtSettleFeeList() throws Exception {
		MchtSettleFeeManager mchtSettleFeeMgr = (MchtSettleFeeManager)SpringContextHolder.getBean(MchtSettleFee.class);
		pageInfo = pageInfo == null ? new MchtSettleFeePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		mchtSettleFees = mchtSettleFeeMgr.getSecurityMchtSettleFeeList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public MchtSettleFee getMchtSettleFee() {
		return mchtSettleFee;
	}

	public void setMchtSettleFee(MchtSettleFee mchtSettleFee) {
		this.mchtSettleFee = mchtSettleFee;
	}
	
	public List<MchtSettleFee> getMchtSettleFees() {
		return mchtSettleFees;
	}

	public void setMchtSettleFees(List<MchtSettleFee> mchtSettleFees) {
		this.mchtSettleFees = mchtSettleFees;
	}

	public MchtSettleFeePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(MchtSettleFeePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
