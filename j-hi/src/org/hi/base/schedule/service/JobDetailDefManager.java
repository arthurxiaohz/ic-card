package org.hi.base.schedule.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.framework.service.Manager;

public interface JobDetailDefManager extends Manager{
	/**
	 * ����/�޸ı��湤�����
	 */
    public void saveJobDetailDef(JobDetailDef jobDetailDef);
    /**
	 * ɾ���������
	 */
    public void removeJobDetailDefById(Integer id);
    /**
     * ��ѯ�������
     * @param id
     * @return
     */
    public JobDetailDef getJobDetailDefById(Integer id);
    /**
     * ��������б�
     * @param id
     * @return
     */
    public List<JobDetailDef> getJobDetailDefList(PageInfo pageInfo);
    
    public void saveSecurityJobDetailDef(JobDetailDef jobDetailDef);
    public void removeSecurityJobDetailDefById(Integer id);
    public JobDetailDef getSecurityJobDetailDefById(Integer id);
    public List<JobDetailDef> getSecurityJobDetailDefList(PageInfo pageInfo);
}
