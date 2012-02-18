package org.hi.base.schedule.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.schedule.action.JobDetailDefPageInfo;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.base.schedule.service.JobDetailDefManager;

public class JobDetailDefListAction extends BaseAction{
	private JobDetailDef jobDetailDef;
	private JobDetailDefPageInfo pageInfo;
	private List<JobDetailDef> jobDetailDefs;
	
	public String execute() throws Exception {
		JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
		pageInfo = pageInfo == null ? new JobDetailDefPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		jobDetailDefs = jobDetailDefMgr.getJobDetailDefList(sarchPageInfo);
		
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
}
