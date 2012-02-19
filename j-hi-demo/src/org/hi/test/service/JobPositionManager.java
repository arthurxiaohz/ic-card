package org.hi.test.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.JobPosition;
import org.hi.framework.service.Manager;

public interface JobPositionManager extends Manager{
    
    public void saveJobPosition(JobPosition jobPosition);

    public void removeJobPositionById(Integer id);

    public JobPosition getJobPositionById(Integer id);

    public List<JobPosition> getJobPositionList(PageInfo pageInfo);
    
    public void saveSecurityJobPosition(JobPosition jobPosition);

    public void removeSecurityJobPositionById(Integer id);

    public JobPosition getSecurityJobPositionById(Integer id);

    public List<JobPosition> getSecurityJobPositionList(PageInfo pageInfo);    
}
