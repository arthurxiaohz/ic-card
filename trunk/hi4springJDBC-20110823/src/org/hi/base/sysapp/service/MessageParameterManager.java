package org.hi.base.sysapp.service;

import java.util.List;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface MessageParameterManager extends Manager
{
  public abstract void saveMessageParameter(MessageParameter paramMessageParameter);

  public abstract void removeMessageParameterById(Integer paramInteger);

  public abstract MessageParameter getMessageParameterById(Integer paramInteger);

  public abstract List<MessageParameter> getMessageParameterList(PageInfo paramPageInfo);

  public abstract void saveSecurityMessageParameter(MessageParameter paramMessageParameter);

  public abstract void removeSecurityMessageParameterById(Integer paramInteger);

  public abstract MessageParameter getSecurityMessageParameterById(Integer paramInteger);

  public abstract List<MessageParameter> getSecurityMessageParameterList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.service.MessageParameterManager
 * JD-Core Version:    0.6.0
 */