package org.hi.base.schedule.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.schedule.action.JobDetailDefPageInfo;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.base.schedule.service.JobDetailDefManager;

public class JobDetailDefAction extends BaseAction{
	private JobDetailDef jobDetailDef;
	private JobDetailDefPageInfo pageInfo;
	private List<JobDetailDef> jobDetailDefs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存工作项定义
	 */
	public String saveJobDetailDef() throws Exception {
		JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
		if(super.perExecute(jobDetailDef)!= null) return returnCommand();
		jobDetailDefMgr.saveJobDetailDef(jobDetailDef);
		super.postExecute(jobDetailDef);
		return returnCommand();
	}
	
	
	/**
	 * 删除工作项定义
	 */
	public String removeJobDetailDef() throws Exception {
		JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
		jobDetailDefMgr.removeJobDetailDefById(jobDetailDef.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些工作项定义  
	 */
	public String removeAllJobDetailDef() throws Exception {
		JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer jobDetailDefid = new Integer( ids[i] );
				jobDetailDefMgr.removeJobDetailDefById(jobDetailDefid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看工作项定义
	 */
	public String viewJobDetailDef() throws Exception {
		JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
		jobDetailDef = jobDetailDefMgr.getJobDetailDefById(jobDetailDef.getId());
		return returnCommand();
	}
	
	/**
	 * 工作项定义列表
	 */
	public String jobDetailDefList() throws Exception {
		JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
		pageInfo = pageInfo == null ? new JobDetailDefPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		jobDetailDefs = jobDetailDefMgr.getSecurityJobDetailDefList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public JobDetailDef getJobDetailDef() {
		return jobDetailDef;
	}

	public void setJobDetailDef(JobDetailDef jobDetailDef) {
		this.jobDetailDef = jobDetailDef;
	}
	
	public List<JobDetailDef> getJobDetailDefs() {
		return jobDetailDefs;
	}

	public void setJobDetailDefs(List<JobDetailDef> jobDetailDefs) {
		this.jobDetailDefs = jobDetailDefs;
	}

	public JobDetailDefPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(JobDetailDefPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
