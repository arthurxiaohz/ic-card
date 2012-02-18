package org.hi.base.sysapp.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.sysapp.model.Message;
import org.hi.base.sysapp.service.MessageManager;
import org.hi.framework.web.SynchronizationData;

public class MessageSaveAction extends BaseAction implements SynchronizationData{
	private Message message;
	
	public String execute() throws Exception {
		if(super.perExecute(message)!= null) return returnCommand();
		MessageManager messageMgr = (MessageManager)SpringContextHolder.getBean(Message.class);
		messageMgr.saveMessage(message);
		super.postExecute(message);
		return returnCommand();
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
