package org.hi.base.schedule.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.framework.service.Manager;

public interface JobDetailDefManager extends Manager{
	/**
	 * 新增/修改保存工作项定义
	 */
    public void saveJobDetailDef(JobDetailDef jobDetailDef);
    /**
	 * 删除工作项定义
	 */
    public void removeJobDetailDefById(Integer id);
    /**
     * 查询工作项定义
     * @param id
     * @return
     */
    public JobDetailDef getJobDetailDefById(Integer id);
    /**
     * 工作项定义列表
     * @param id
     * @return
     */
    public List<JobDetailDef> getJobDetailDefList(PageInfo pageInfo);
    
    public void saveSecurityJobDetailDef(JobDetailDef jobDetailDef);
    public void removeSecurityJobDetailDefById(Integer id);
    public JobDetailDef getSecurityJobDetailDefById(Integer id);
    public List<JobDetailDef> getSecurityJobDetailDefList(PageInfo pageInfo);
}
