package org.hi.base.sysapp.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.framework.service.Manager;

public interface MessageParameterManager extends Manager{
    
    public void saveMessageParameter(MessageParameter messageParameter);

    public void removeMessageParameterById(Integer id);

    public MessageParameter getMessageParameterById(Integer id);

    public List<MessageParameter> getMessageParameterList(PageInfo pageInfo);
    
    public void saveSecurityMessageParameter(MessageParameter messageParameter);
    public void removeSecurityMessageParameterById(Integer id);
    public MessageParameter getSecurityMessageParameterById(Integer id);
    public List<MessageParameter> getSecurityMessageParameterList(PageInfo pageInfo);
}
