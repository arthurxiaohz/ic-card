package org.hi.base.sysapp.service;

import java.util.List;
import org.hi.base.sysapp.model.Message;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface MessageManager extends Manager
{
  public abstract void saveMessage(Message paramMessage);

  public abstract void removeMessageById(Integer paramInteger);

  public abstract Message getMessageById(Integer paramInteger);

  public abstract List<Message> getMessageList(PageInfo paramPageInfo);

  public abstract void saveSecurityMessage(Message paramMessage);

  public abstract void removeSecurityMessageById(Integer paramInteger);

  public abstract Message getSecurityMessageById(Integer paramInteger);

  public abstract List<Message> getSecurityMessageList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.service.MessageManager
 * JD-Core Version:    0.6.0
 */