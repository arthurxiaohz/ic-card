package org.hi.base.sysapp.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.sysapp.model.Message;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.sysapp.service.MessageManager;

public class MessageManagerImpl extends ManagerImpl implements MessageManager{
    
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
    
    public void saveMessage(Message message){
    	saveObject(message);
    
    }

    public void removeMessageById(Integer id){
    	removeObjectById(id);
    	
    }

    public Message getMessageById(Integer id){
   		return (Message) getObjectById(id);
    }

    public List<Message> getMessageList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityMessage(Message message){
    	saveObject(message);
    }
    public void removeSecurityMessageById(Integer id){
    	removeObjectById(id);
    }
    public Message getSecurityMessageById(Integer id){
    	return (Message) getObjectById(id);
    }
    public List<Message> getSecurityMessageList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    } 
}
