package org.hi.base.sysapp.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.sysapp.service.MessageParameterManager;

public class MessageParameterManagerImpl extends ManagerImpl implements MessageParameterManager{
    
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
    
    public void saveMessageParameter(MessageParameter messageParameter){
    	saveObject(messageParameter);
    
    }

    public void removeMessageParameterById(Integer id){
    	removeObjectById(id);
    	
    }

    public MessageParameter getMessageParameterById(Integer id){
   		return (MessageParameter) getObjectById(id);
    }

    public List<MessageParameter> getMessageParameterList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityMessageParameter(MessageParameter messageParameter){
    	saveObject(messageParameter);
    }
    public void removeSecurityMessageParameterById(Integer id){
    	removeObjectById(id);
    }
    public MessageParameter getSecurityMessageParameterById(Integer id){
    	return (MessageParameter) getObjectById(id);
    }
    public List<MessageParameter> getSecurityMessageParameterList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
