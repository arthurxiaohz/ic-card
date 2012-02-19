package org.hi.test.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.test.model.MchtSettleFee;
import org.hi.test.service.impl.MbMchtInfManagerImpl;
import org.hi.test.service.MchtSettleFeeManager;

public class MchtSettleFeeManagerImpl extends MbMchtInfManagerImpl implements MchtSettleFeeManager{
    
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    
    public void saveMchtSettleFee(MchtSettleFee mchtSettleFee){
    	saveObject(mchtSettleFee);
    
    }

    public void removeMchtSettleFeeById(Integer id){
    	removeObjectById(id);
    	
    }

    public MchtSettleFee getMchtSettleFeeById(Integer id){
   		return (MchtSettleFee) getObjectById(id);
    }

    public List<MchtSettleFee> getMchtSettleFeeList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityMchtSettleFee(MchtSettleFee mchtSettleFee){
    	saveObject(mchtSettleFee);
    
    }

    public void removeSecurityMchtSettleFeeById(Integer id){
    	removeObjectById(id);
    	
    }

    public MchtSettleFee getSecurityMchtSettleFeeById(Integer id){
   		return (MchtSettleFee) getObjectById(id);
    }

    public List<MchtSettleFee> getSecurityMchtSettleFeeList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }    
}
