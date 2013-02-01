package org.hi.base.sysapp.message;

import java.util.Date;
import java.util.List;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.framework.web.BusinessException;

public abstract interface MessageProvider
{
  public static final String MESSAGE_PARAMETER_ALL = "ALL";
  public static final String MESSAGE_PARAMETER_SUBJECT = "SUBJECT";

  public abstract void sendMessage(Message paramMessage)
    throws BusinessException;

  public abstract String getReceivers(String paramString);

  public abstract Message creatMessage(String paramString1, String paramString2, String paramString3, Date paramDate, String paramString4, List<MessageParameter> paramList);

  public abstract Message creatMessage(String paramString1, String paramString2, String paramString3, Date paramDate, String paramString4);

  public abstract Message creatMessage(String paramString1, String paramString2, String paramString3);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.MessageProvider
 * JD-Core Version:    0.6.0
 */