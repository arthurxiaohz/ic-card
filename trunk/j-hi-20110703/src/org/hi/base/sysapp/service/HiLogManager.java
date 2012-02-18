package org.hi.base.sysapp.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.sysapp.model.HiLog;
import org.hi.framework.service.Manager;

public interface HiLogManager extends Manager{
    
    public void saveHiLog(HiLog hiLog);

    public void removeHiLogById(Integer id);

    public HiLog getHiLogById(Integer id);

    public List<HiLog> getHiLogList(PageInfo pageInfo);
    
    public void saveSecurityHiLog(HiLog hiLog);

    public void removeSecurityHiLogById(Integer id);

    public HiLog getSecurityHiLogById(Integer id);

    public List<HiLog> getSecurityHiLogList(PageInfo pageInfo);    
}
