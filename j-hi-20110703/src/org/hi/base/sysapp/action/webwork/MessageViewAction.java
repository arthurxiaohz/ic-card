package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.service.MessageManager;

public class MessageViewAction extends BaseAction{
	private Message message;
	
	public String execute() throws Exception {
		MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		message = messageMgr.getMessageById(message.getId());
		return returnCommand();
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
