package org.hi.test.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.test.action.JobPositionPageInfo;
import org.hi.test.model.JobPosition;
import org.hi.test.service.JobPositionManager;

public class JobPositionAction extends BaseAction{
	private JobPosition jobPosition;
	private JobPositionPageInfo pageInfo;
	private List<JobPosition> jobPositions;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存JobPosition
	 */
	public String saveJobPosition() throws Exception {
		JobPositionManager jobPositionMgr = (JobPositionManager)SpringContextHolder.getBean(JobPosition.class);
		if(super.perExecute(jobPosition)!= null) return returnCommand();
		jobPositionMgr.saveJobPosition(jobPosition);
		super.postExecute(jobPosition);
		return returnCommand();
	}
	
	
	/**
	 * 删除JobPosition
	 */
	public String removeJobPosition() throws Exception {
		JobPositionManager jobPositionMgr = (JobPositionManager)SpringContextHolder.getBean(JobPosition.class);
		jobPositionMgr.removeJobPositionById(jobPosition.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些JobPosition
	 */
	public String removeAllJobPosition() throws Exception {
		JobPositionManager jobPositionMgr = (JobPositionManager)SpringContextHolder.getBean(JobPosition.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer jobPositionid = new Integer( ids[i] );
				jobPositionMgr.removeJobPositionById(jobPositionid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看JobPosition
	 */
	public String viewJobPosition() throws Exception {
		JobPositionManager jobPositionMgr = (JobPositionManager)SpringContextHolder.getBean(JobPosition.class);
		jobPosition = jobPositionMgr.getJobPositionById(jobPosition.getId());
		return returnCommand();
	}
	
	/**
	 * JobPosition列表
	 */
	public String jobPositionList() throws Exception {
		JobPositionManager jobPositionMgr = (JobPositionManager)SpringContextHolder.getBean(JobPosition.class);
		pageInfo = pageInfo == null ? new JobPositionPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		jobPositions = jobPositionMgr.getSecurityJobPositionList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public JobPosition getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}
	
	public List<JobPosition> getJobPositions() {
		return jobPositions;
	}

	public void setJobPositions(List<JobPosition> jobPositions) {
		this.jobPositions = jobPositions;
	}

	public JobPositionPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(JobPositionPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
