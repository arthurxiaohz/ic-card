package org.hi.base.sysapp.message;

import java.util.Date;
import java.util.List;

import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.framework.web.BusinessException;

/**
 * 
 * @author ’≈Íª
 * @since 2009-01-01
 *
 */
public interface MessageProvider {
	public static final String MESSAGE_PARAMETER_ALL = "ALL";
	public static final String MESSAGE_PARAMETER_SUBJECT = "SUBJECT";
	public void sendMessage(Message message) throws BusinessException;
	public String getReceivers(String ids);
	public Message creatMessage(String receivers, String receiverNames,String sender, 
			Date sendDate,String messageText, List<MessageParameter> pars);
	public Message creatMessage(String receivers, String receiverNames, String sender, Date sendDate, String messageText);
	public Message creatMessage(String receivers, String sender, String messageText);
}
