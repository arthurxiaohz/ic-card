package org.hi.test.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.MbMchtInf;
import org.hi.framework.service.Manager;

public interface MbMchtInfManager extends Manager{
    
    public void saveMbMchtInf(MbMchtInf mbMchtInf);

    public void removeMbMchtInfById(Integer id);

    public MbMchtInf getMbMchtInfById(Integer id);

    public List<MbMchtInf> getMbMchtInfList(PageInfo pageInfo);
    
    public void saveSecurityMbMchtInf(MbMchtInf mbMchtInf);

    public void removeSecurityMbMchtInfById(Integer id);

    public MbMchtInf getSecurityMbMchtInfById(Integer id);

    public List<MbMchtInf> getSecurityMbMchtInfList(PageInfo pageInfo);    
}
