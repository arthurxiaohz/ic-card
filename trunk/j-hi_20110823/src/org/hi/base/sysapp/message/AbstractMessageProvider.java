package org.hi.base.sysapp.message;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.model.MessageParameter;
import org.hi.base.sysapp.service.MessageManager;

public abstract class AbstractMessageProvider implements MessageProvider {
	
	private String messageType;
	protected boolean remove;
	protected boolean persistence;
	
	public Message creatMessage(String receivers, String receiverNames,
			String sender, Date sendDate, String messageText,
			List<MessageParameter> pars) {
		
		Message message = new Message();
		message.setReceivers(receivers);
		message.setReceiverNames(receiverNames);
		message.setSender(sender);
		message.setCreateDate(new Timestamp(new Date().getTime()));
		if(sendDate == null)
			message.setSendDate(new Timestamp(new Date().getTime()));
		else
			message.setSendDate(new Timestamp(sendDate.getTime()));
		message.setMessageText(messageText);
		message.setMessageType(new Integer(this.getMessageType()));
		
		if(pars != null && pars.size() >0){
			for (MessageParameter messageParameter : pars) 
				messageParameter.setMessage(message);
			
			message.setMessageParameters(pars);
		}
		
		//持久化,保存到数据库中
		if(persistence){
			MessageManager mesgMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
			mesgMgr.saveObject(message);
		}
		
		MessageProviderManager providerMgr = (MessageProviderManager)SpringContextHolder.getBean(MessageProviderManager.SPRING_BEAN_ID);
		if(providerMgr.cache)
			providerMgr.addMessage(message);
		
		return message;
	}
	
	public Message creatMessage(String receivers, String receiverNames,
			String sender, Date sendDate, String messageText) {
		return creatMessage(receivers, receiverNames, sender, sendDate, messageText, null);
	}
	
	public Message creatMessage(String receivers, String sender, String messageText) {
		return creatMessage(receivers, null, sender, null, messageText, null);
	}
	
	public void sentProcess(Message message){
		MessageProviderManager providerMgr = (MessageProviderManager)SpringContextHolder.getBean(MessageProviderManager.SPRING_BEAN_ID);
		MessageManager mesgMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		if(providerMgr.cache){
			providerMgr.removeMessage(message);
		}
//		message.getMessageParameters().clear();
//		message = (Message) mesgMgr.getObjectById(message.getId());
		if(persistence){
			if(this.isRemove()){
				mesgMgr.removeObject(message);
			}
			else{
				message.setIsSent(YesNo.YESNO_YES);
				mesgMgr.saveObject(message);
			}
		}
	}
	
	
	protected String getParameter(List<MessageParameter> parameters, String key){
		if( parameters == null || parameters.size() == 0)
			return null;
		for (MessageParameter parameter : parameters) 
			if(parameter.getParameterKey().equals(key))
					return parameter.getParameterValue();
		
		return null;
	}
	
	public abstract String[] getAllReceivers();
	
	public boolean isRemove(){
		return this.remove ;
	}
	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	public boolean isPersistence() {
		return persistence;
	}

	public void setPersistence(boolean persistence) {
		this.persistence = persistence;
	}


}
