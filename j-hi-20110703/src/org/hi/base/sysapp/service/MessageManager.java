package org.hi.base.sysapp.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.sysapp.model.Message;
import org.hi.framework.service.Manager;

public interface MessageManager extends Manager{
    
    public void saveMessage(Message message);

    public void removeMessageById(Integer id);

    public Message getMessageById(Integer id);

    public List<Message> getMessageList(PageInfo pageInfo);
    
    public void saveSecurityMessage(Message message);
    public void removeSecurityMessageById(Integer id);
    public Message getSecurityMessageById(Integer id);
    public List<Message> getSecurityMessageList(PageInfo pageInfo);
}
