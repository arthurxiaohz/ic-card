package org.hi.test.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.MchtSettleFee;
import org.hi.test.service.MbMchtInfManager;

public interface MchtSettleFeeManager extends MbMchtInfManager{
    
    public void saveMchtSettleFee(MchtSettleFee mchtSettleFee);

    public void removeMchtSettleFeeById(Integer id);

    public MchtSettleFee getMchtSettleFeeById(Integer id);

    public List<MchtSettleFee> getMchtSettleFeeList(PageInfo pageInfo);
    
    public void saveSecurityMchtSettleFee(MchtSettleFee mchtSettleFee);

    public void removeSecurityMchtSettleFeeById(Integer id);

    public MchtSettleFee getSecurityMchtSettleFeeById(Integer id);

    public List<MchtSettleFee> getSecurityMchtSettleFeeList(PageInfo pageInfo);    
}
